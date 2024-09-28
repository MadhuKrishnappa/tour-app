package com.tour.app.services.impl;

import com.tour.app.das.IAccommodationDetailDao;
import com.tour.app.das.IFlightDetailDao;
import com.tour.app.das.IPackageTouringCityMapping;
import com.tour.app.das.IPackageDao;
import com.tour.app.das.IPackageDepartureCityDateMappingDao;
import com.tour.app.das.IPackageItineraryAddonDao;
import com.tour.app.das.IPackageItineraryDao;
import com.tour.app.das.IPackageRateDao;
import com.tour.app.das.IPackageThemeDao;
import com.tour.app.das.IPackageThemeMappingDao;
import com.tour.app.das.IPackageTypeDao;
import com.tour.app.das.IPackageTypeMappingDao;
import com.tour.app.das.IReportingAndDroppingDao;
import com.tour.app.das.ITourInformationDao;
import com.tour.app.entity.AccommodationDetails;
import com.tour.app.entity.FlightDetails;
import com.tour.app.entity.PackageDepartureCityDateMapping;
import com.tour.app.entity.PackageTouringCityMapping;
import com.tour.app.entity.PackageItinerary;
import com.tour.app.entity.PackageItineraryAddon;
import com.tour.app.entity.PackageRates;
import com.tour.app.entity.PackageTheme;
import com.tour.app.entity.PackageThemeMapping;
import com.tour.app.entity.PackageType;
import com.tour.app.entity.PackageTypeMapping;
import com.tour.app.entity.Packages;
import com.tour.app.entity.ReportingAndDroppingDetail;
import com.tour.app.entity.TourInformation;
import com.tour.app.model.enums.PackageThemeEnum;
import com.tour.app.model.enums.PackageTypeEnum;
import com.tour.app.model.enums.Status;
import com.tour.app.model.vo.AccommodationDetailVO;
import com.tour.app.model.vo.FlightDetailVO;
import com.tour.app.model.vo.PackageItineraryAddons;
import com.tour.app.model.vo.PackageItineraryVO;
import com.tour.app.model.vo.ReportingAndDropping;
import com.tour.app.model.vo.TourDetailsVO;
import com.tour.app.model.vo.TourInformationVO;
import com.tour.app.model.vo.TourPackageVO;
import com.tour.app.request.AddPackageRequest;
import com.tour.app.request.FetchPackageRequest;
import com.tour.app.services.IPackageService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements IPackageService {

    @Autowired
    IPackageDao packageDAO;

    @Autowired
    IPackageRateDao packageRateDao;

    @Autowired
    IPackageItineraryDao packageItineraryDao;

    @Autowired
    IPackageItineraryAddonDao packageItineraryAddonDao;

    @Autowired
    IPackageTouringCityMapping packageTouringCityMappingDao;

    @Autowired
    IPackageTypeDao packageTypeDao;

    @Autowired
    IPackageTypeMappingDao packageTypeMappingDao;

    @Autowired
    IPackageThemeDao packageThemeDao;

    @Autowired
    IPackageThemeMappingDao packageThemeMappingDao;

    @Autowired
    IPackageDepartureCityDateMappingDao packageDepartureCityDateMappingDao;

    @Autowired
    ITourInformationDao tourInformationDao;

    @Autowired
    IReportingAndDroppingDao reportingAndDroppingDao;

    @Autowired
    IAccommodationDetailDao accommodationDetailDao;

    @Autowired
    IFlightDetailDao flightDetailDao;


    @Override
    public TourPackageVO fetchPackages(FetchPackageRequest fetchPackageRequest) throws Exception {

        if(fetchPackageRequest == null){
            throw new Exception("Request is mandatory");
        }

        Packages packages = packageDAO.getPackageById(1000);

        TourPackageVO tourPackageVO = new TourPackageVO();
        tourPackageVO.setId(packages.getId());
        tourPackageVO.setPackageName(packages.getPackageName());
        tourPackageVO.setPackageCode(packages.getPackageCode());


        return tourPackageVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addPackages(AddPackageRequest addPackageRequest) throws Exception {

        if(addPackageRequest == null){
            throw new Exception("Request is mandatory");
        }

        List<TourPackageVO> tourPackages = addPackageRequest.getPackages();


        for (int i=0; i<tourPackages.size(); i++){
            TourPackageVO tourPackage = tourPackages.get(i);

            Packages packages = new Packages();
            packages.setPackageName(tourPackage.getPackageName());
            packages.setPackageCode(tourPackage.getPackageCode());
            if(!tourPackage.getPackageListImages().isEmpty()) {
                packages.setPackageListImages(StringUtils.join(tourPackage.getPackageListImages(), ','));
            }
            if(!tourPackage.getPackageDetailImages().isEmpty()) {
                packages.setPackageDetailImages(StringUtils.join(tourPackage.getPackageDetailImages(), ','));
            }

            packages.setPackageRating(tourPackage.getPackageRating());
            packages.setPackageReviews(tourPackage.getTotalPackageReviews());
            packages.setDurationDays(tourPackage.getDurationDays());
            packages.setDurationNights(tourPackage.getDurationNights());
            packages.setStatus(Status.ACTIVE.toString());
            if(!tourPackage.getTourIncludes().isEmpty()) {
                String commaSeperatedTourIncludes = tourPackage.getTourIncludes()
                        .stream().map(String::valueOf).collect(Collectors.joining(","));
                packages.setTourIncludes(commaSeperatedTourIncludes);
            }

            packages = packageDAO.addPackage(packages);

            BigInteger packageId = packages.getId();

            if(!tourPackage.getTouringCities().isEmpty()) {
                for(int ci = 0; ci < tourPackage.getTouringCities().size(); ci++) {
                    PackageTouringCityMapping packageTouringCityMapping = new PackageTouringCityMapping();
                    packageTouringCityMapping.setPackageId(packageId);
                    packageTouringCityMapping.setCityId(tourPackage.getTouringCities().get(ci));
                    packageTouringCityMapping.setStatus(Status.ACTIVE.toString());
                    this.packageTouringCityMappingDao.add(packageTouringCityMapping);
                }
            }

            if(!tourPackage.getDepartureCityDatesMappings().isEmpty()) {
                for (Map.Entry<BigInteger, List<Date>> entry : tourPackage.getDepartureCityDatesMappings().entrySet()){
                    BigInteger cityId = entry.getKey();
                    for(Date departureDate : entry.getValue()){
                        PackageDepartureCityDateMapping departureCityDateMapping = new PackageDepartureCityDateMapping();
                        departureCityDateMapping.setPackageId(packageId);
                        departureCityDateMapping.setCityId(cityId);
                        departureCityDateMapping.setDepartureDate(departureDate);
                        departureCityDateMapping.setStatus(Status.ACTIVE.toString());
                        packageDepartureCityDateMappingDao.add(departureCityDateMapping);
                    }
                }
            }

            if(!tourPackage.getPackageTypes().isEmpty()){
                for(int pt = 0; pt<tourPackage.getPackageTypes().size(); pt++){
                    PackageTypeEnum packageType = tourPackage.getPackageTypes().get(pt);
                    PackageType packageTypeEntity = packageTypeDao.getByPackageType(packageType);
                    if(packageTypeEntity == null){
                        throw new Exception("Invalid PackageType");
                    }
                    PackageTypeMapping packageTypeMapping = new PackageTypeMapping();
                    packageTypeMapping.setPackageTypeId(packageTypeEntity.getId());
                    packageTypeMapping.setPackageId(packageId);
                    packageTypeMapping.setStatus(Status.ACTIVE.toString());
                    packageTypeMappingDao.add(packageTypeMapping);
                }
            }

            if(!tourPackage.getPackageThemes().isEmpty()){
                for (int pt = 0; pt < tourPackage.getPackageThemes().size(); pt++){
                    PackageThemeEnum packageThemeEnum = tourPackage.getPackageThemes().get(pt);
                    PackageTheme packageThemeEntity = packageThemeDao.getByPackageTheme(packageThemeEnum);
                    if(packageThemeEntity == null){
                        throw new Exception("Invalid Package Theme");
                    }
                    PackageThemeMapping packageThemeMapping = new PackageThemeMapping();
                    packageThemeMapping.setPackageId(packageId);
                    packageThemeMapping.setPackageThemeId(packageThemeEntity.getId());
                    packageThemeMapping.setStatus(Status.ACTIVE.toString());
                    packageThemeMappingDao.add(packageThemeMapping);

                }
            }

            for (int pr = 0; pr < tourPackage.getPackageRates().size(); pr++) {

                PackageRates packageRates = new PackageRates();
                packageRates.setPackageId(packageId);
                packageRates.setPackageRateType(tourPackage.getPackageRates().get(pr).getPackageRateType().toString());
                packageRates.setGuestSharingType(tourPackage.getPackageRates().get(pr).getGuestSharingType().toString());
                packageRates.setAdultRate(tourPackage.getPackageRates().get(pr).getAdultRate());
                packageRates.setChildRateWithBed(tourPackage.getPackageRates().get(pr).getChildRateWithBed());
                packageRates.setChildRateWithoutBed(tourPackage.getPackageRates().get(pr).getChildRateWithoutBed());
                packageRates.setInfantRate(tourPackage.getPackageRates().get(pr).getInfantRate());
                packageRates.setDescription(tourPackage.getPackageRates().get(pr).getDescription());
                packageRates.setStatus(Status.ACTIVE.toString());
                packageRateDao.addPackageRates(packageRates);
            }

            List<PackageItineraryVO> itineraries = tourPackage.getItineraries();

            for(int it = 0; it < itineraries.size(); it++){

                PackageItinerary packageItinerary = new PackageItinerary();
                packageItinerary.setPackageId(packageId);
                packageItinerary.setItineraryTitle(itineraries.get(it).getItineraryTitle());
                if(!itineraries.get(it).getItineraryImages().isEmpty()) {
                    packageItinerary.setItineraryImages(StringUtils.join(itineraries.get(it).getItineraryImages()));
                }
                packageItinerary.setItineraryDate(itineraries.get(it).getItineraryDate());
                packageItinerary.setDescription(itineraries.get(it).getDescription());
                packageItinerary.setNote(itineraries.get(it).getNote());
                if(!itineraries.get(it).getCityIds().isEmpty()) {
                    String commaSeperatedCityIds = itineraries.get(it).getCityIds()
                            .stream().map(String::valueOf).collect(Collectors.joining(","));
                    packageItinerary.setCityIds(commaSeperatedCityIds);
                }
                packageItinerary.setDayCount(itineraries.get(it).getDayCount());
                packageItinerary.setStatus(Status.ACTIVE.toString());
                packageItinerary = packageItineraryDao.addPackageItinerary(packageItinerary);

                BigInteger piId = packageItinerary.getId();

                for(int ia = 0; ia < itineraries.get(it).getItineraryAddons().size(); ia++) {
                    PackageItineraryAddons itAddOnVO = itineraries.get(it).getItineraryAddons().get(ia);
                    PackageItineraryAddon itineraryAddon = new PackageItineraryAddon();
                    itineraryAddon.setPackageItineraryId(piId);
                    itineraryAddon.setAddonType(itAddOnVO.getItineraryAddonType().toString());
                    itineraryAddon.setDescription(itAddOnVO.getDescription());
                    itineraryAddon.setStatus(Status.ACTIVE.toString());
                    packageItineraryAddonDao.add(itineraryAddon);
                }
            }

            TourDetailsVO tourDetails = tourPackage.getTourDetails();

            for(AccommodationDetailVO accommodationDetailVO : tourDetails.getAccommodationDetails()){

                AccommodationDetails accommodationDetail = new AccommodationDetails();
                accommodationDetail.setPackageId(packageId);
                accommodationDetail.setSequenceCount(accommodationDetailVO.getSequenceCount());
                accommodationDetail.setCityIds(accommodationDetailVO.getCityIds().stream().map(e -> e.toString()).collect(Collectors.joining(",")));
                accommodationDetail.setHotelName(accommodationDetailVO.getHotelName());
                accommodationDetail.setCheckInDate(accommodationDetailVO.getCheckInDate());
                accommodationDetail.setCheckOutDate(accommodationDetailVO.getCheckOutDate());
                accommodationDetail.setStatus(Status.ACTIVE.toString());

                accommodationDetailDao.add(accommodationDetail);
            }

            for (ReportingAndDropping reportingAndDropping : tourDetails.getReportingAndDroppings()){
                ReportingAndDroppingDetail reportingAndDroppingDetail = new ReportingAndDroppingDetail();
                reportingAndDroppingDetail.setPackageId(packageId);
                reportingAndDroppingDetail.setGuestType(reportingAndDropping.getGuestType());
                reportingAndDroppingDetail.setReportingPoint(reportingAndDropping.getReportingPoint());
                reportingAndDroppingDetail.setDroppingPoint(reportingAndDropping.getDroppingPoint());
                reportingAndDroppingDetail.setStatus(Status.ACTIVE.toString());

                reportingAndDroppingDao.add(reportingAndDroppingDetail);

            }

            FlightDetailVO flightDetailVO = tourDetails.getFlightDetails();
            FlightDetails flightDetail = new FlightDetails();
            flightDetail.setPackageId(packageId);
            flightDetail.setFlightName(flightDetailVO.getFlightName());
            flightDetail.setDepartureCityId(flightDetailVO.getDepartureCityId());
            flightDetail.setDepartureDate(flightDetailVO.getDepartureDate());
            flightDetail.setArrivalCityId(flightDetailVO.getArrivalCityId());
            flightDetail.setArrivalDate(flightDetailVO.getArrivalDate());
            flightDetail.setStatus(Status.ACTIVE.toString());
            flightDetailDao.add(flightDetail);

            List<TourInformationVO> tourInfoList = tourPackage.getTourInformation();

            for(TourInformationVO tourInformationVO: tourInfoList){
                TourInformation tourInformation = new TourInformation();
                tourInformation.setPackageId(packageId);
                tourInformation.setInformationType(tourInformationVO.getInformationType());
                tourInformation.setDescription(tourInformationVO.getDescription());
                tourInformation.setStatus(Status.ACTIVE.toString());

                tourInformationDao.add(tourInformation);
            }

        }
    }
}
