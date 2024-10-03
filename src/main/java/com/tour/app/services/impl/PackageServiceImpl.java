package com.tour.app.services.impl;

import com.tour.app.das.IAccommodationDetailDao;
import com.tour.app.das.ICityDao;
import com.tour.app.das.ICountryDao;
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
import com.tour.app.das.IStateDao;
import com.tour.app.das.ITourInformationDao;
import com.tour.app.entity.AccommodationDetails;
import com.tour.app.entity.City;
import com.tour.app.entity.Country;
import com.tour.app.entity.FetchPackageList;
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
import com.tour.app.entity.State;
import com.tour.app.entity.TourInformation;
import com.tour.app.model.FetchPackageListVO;
import com.tour.app.model.enums.GuestSharingTypeEnum;
import com.tour.app.model.enums.PackageItineraryAddonTypeEnum;
import com.tour.app.model.enums.PackageRateTypeEnum;
import com.tour.app.model.enums.PackageThemeEnum;
import com.tour.app.model.enums.PackageTypeEnum;
import com.tour.app.model.enums.Status;
import com.tour.app.model.enums.TourInformationEnum;
import com.tour.app.model.vo.AccommodationDetailVO;
import com.tour.app.model.vo.CityVO;
import com.tour.app.model.vo.CountryVO;
import com.tour.app.model.vo.FlightDetailVO;
import com.tour.app.model.vo.PackageDetailsVO;
import com.tour.app.model.vo.PackageItineraryAddons;
import com.tour.app.model.vo.PackageItineraryVO;
import com.tour.app.model.vo.PackageRateVO;
import com.tour.app.model.vo.ReportingAndDroppingVO;
import com.tour.app.model.vo.StateVO;
import com.tour.app.model.vo.TourDetailsVO;
import com.tour.app.model.vo.TourInformationVO;
import com.tour.app.model.vo.TourPackageVO;
import com.tour.app.request.AddPackageRequest;
import com.tour.app.request.FetchPackageRequest;
import com.tour.app.response.FetchPackageResponse;
import com.tour.app.response.PackageDetailResponse;
import com.tour.app.services.IPackageService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    ICityDao cityDao;

    @Autowired
    IStateDao stateDao;

    @Autowired
    ICountryDao countryDao;


    @Override
    public FetchPackageResponse fetchPackages(FetchPackageRequest fetchPackageRequest) throws Exception {

        if(fetchPackageRequest == null){
            throw new Exception("Request is mandatory");
        }

        List<FetchPackageList> packageList = packageDAO.getPackageListingByFilter(fetchPackageRequest);
        List<FetchPackageListVO> fetchPackageListVOList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(packageList)){
            for (FetchPackageList fetchPackageList : packageList){
                FetchPackageListVO fetchPackageListVO = new FetchPackageListVO();
                fetchPackageListVO.setPackageId(fetchPackageList.getPackageId());
                fetchPackageListVO.setPackageName(fetchPackageList.getPackageName());
                fetchPackageListVO.setPackageCode(fetchPackageList.getPackageCode());
                fetchPackageListVO.setDurationDays(fetchPackageList.getDurationDays());
                fetchPackageListVO.setDurationNights(fetchPackageList.getDurationNights());
                fetchPackageListVO.setPackageRating(fetchPackageList.getPackageRating());
                fetchPackageListVO.setPackageReviews(fetchPackageList.getPackageReviews());
                if(fetchPackageList.getPackageListImages() != null) {
                    fetchPackageListVO.setPackageListImages(Arrays.asList(fetchPackageList.getPackageListImages().split("\\s*,\\s*")));
                }
                if(fetchPackageList.getDepartureCities()!= null) {
                    fetchPackageListVO.setDepartureCities(Arrays.asList(fetchPackageList.getDepartureCities().split("\\s*,\\s*")));
                }
                if(fetchPackageList.getDepartureDates()!= null) {
                    fetchPackageListVO.setDepartureDates(Arrays.asList(fetchPackageList.getDepartureDates().split("\\s*,\\s*")));
                }
                fetchPackageListVO.setPackageRateStartsFrom(fetchPackageList.minPackagePrice);
                if(fetchPackageList.getTourIncludes() != null) {
                    fetchPackageListVO.setTourIncludes(Arrays.asList(fetchPackageList.getTourIncludes().split("\\s*,\\s*")));
                }
                fetchPackageListVOList.add(fetchPackageListVO);
            }
        }


        FetchPackageResponse response = new FetchPackageResponse();
        response.setFetchPackageList(fetchPackageListVOList);

        return response;
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
                accommodationDetail.setCityId(accommodationDetailVO.getCityId());
                accommodationDetail.setHotelName(accommodationDetailVO.getHotelName());
                accommodationDetail.setCheckInDate(accommodationDetailVO.getCheckInDate());
                accommodationDetail.setCheckOutDate(accommodationDetailVO.getCheckOutDate());
                accommodationDetail.setStatus(Status.ACTIVE.toString());

                accommodationDetailDao.add(accommodationDetail);
            }

            for (ReportingAndDroppingVO reportingAndDroppingVO : tourDetails.getReportingAndDroppingVOS()){
                ReportingAndDroppingDetail reportingAndDroppingDetail = new ReportingAndDroppingDetail();
                reportingAndDroppingDetail.setPackageId(packageId);
                reportingAndDroppingDetail.setGuestType(reportingAndDroppingVO.getGuestType());
                reportingAndDroppingDetail.setReportingPoint(reportingAndDroppingVO.getReportingPoint());
                reportingAndDroppingDetail.setDroppingPoint(reportingAndDroppingVO.getDroppingPoint());
                reportingAndDroppingDetail.setStatus(Status.ACTIVE.toString());

                reportingAndDroppingDao.add(reportingAndDroppingDetail);

            }

            List<FlightDetailVO> flightDetailsList = tourDetails.getFlightDetails();
            if(!CollectionUtils.isEmpty(flightDetailsList)) {
                for (FlightDetailVO flightDetailVO : flightDetailsList) {
                    FlightDetails flightDetail = new FlightDetails();
                    flightDetail.setPackageId(packageId);
                    flightDetail.setFlightName(flightDetailVO.getFlightName());
                    flightDetail.setDepartureCityId(flightDetailVO.getDepartureCityId());
                    flightDetail.setDepartureDate(flightDetailVO.getDepartureDate());
                    flightDetail.setArrivalCityId(flightDetailVO.getArrivalCityId());
                    flightDetail.setArrivalDate(flightDetailVO.getArrivalDate());
                    flightDetail.setStatus(Status.ACTIVE.toString());
                    flightDetailDao.add(flightDetail);
                }
            }

            List<TourInformationVO> tourInfoList = tourPackage.getTourInformation();

            for(TourInformationVO tourInformationVO: tourInfoList){
                TourInformation tourInformation = new TourInformation();
                tourInformation.setPackageId(packageId);
                tourInformation.setInformationType(tourInformationVO.getInformationType().toString());
                tourInformation.setDescription(tourInformationVO.getDescription());
                tourInformation.setStatus(Status.ACTIVE.toString());

                tourInformationDao.add(tourInformation);
            }

        }
    }

    @Override
    public PackageDetailResponse fetchPackageDetails(BigInteger packageId) throws Exception {


        if(packageId == null){
            throw new Exception("PackageId is mandatory");
        }

        FetchPackageRequest fetchPackageRequest = new FetchPackageRequest();
        fetchPackageRequest.setPackageIds(Arrays.asList(packageId));
        List<FetchPackageList> packageList = packageDAO.getPackageListingByFilter(fetchPackageRequest);
        if(CollectionUtils.isEmpty(packageList)){
            throw new Exception("Invalid PackageId");
        }
        FetchPackageList data = packageList.get(0);
        PackageDetailResponse detailResponse = new PackageDetailResponse();
        PackageDetailsVO packageDetails = new PackageDetailsVO();
        packageDetails.setId(data.getPackageId());
        packageDetails.setPackageName(data.getPackageName());
        packageDetails.setPackageCode(data.getPackageCode());


        if(data.getPackageListImages() != null){
            List<String> listImages = Stream.of(data.getPackageListImages().split(","))
                    .map(String::toString)
                    .collect(Collectors.toList());

            packageDetails.setPackageListImages(listImages);
        }
        if(data.getPackageDetailImages() != null){
            List<String> detailImages = Stream.of(data.getPackageDetailImages().split(","))
                    .map(String::toString)
                    .collect(Collectors.toList());

            packageDetails.setPackageDetailImages(detailImages);
        }
        if(data.getDepartureCityIds() != null){
            List<BigInteger> depCities = Stream.of(data.getDepartureCityIds().split(","))
                    .map(BigInteger::new)
                    .collect(Collectors.toList());

            packageDetails.setDepartureCities(getCityDetailsByCityIds(depCities));
        }

        packageDetails.setDurationDays(data.getDurationDays());
        packageDetails.setDurationNights(data.getDurationNights());
        packageDetails.setPackageRating(data.getPackageRating());
        packageDetails.setTotalPackageReviews(data.getPackageReviews());
        packageDetails.setMinPackagePrice(data.getMinPackagePrice());
        packageDetails.setDepartureCityDatesMappings(getDepartureCityDateMappingsByPackageId(data.getPackageId()));
        if(data.getDepartureDates() != null){
        List<String> depDates = Stream.of(data.getDepartureDates().split(","))
                .map(String::toString)
                .collect(Collectors.toList());
            packageDetails.setDepartureDates(depDates);
        }
        if(data.getPackageTypes() != null){
            List<String> packageTypes = Stream.of(data.getPackageTypes().split(","))
                    .map(String::toString)
                    .collect(Collectors.toList());
            packageDetails.setPackageTypes(packageTypes);
        }

        if(data.getPackageThemes() != null){
            List<String> packageThemes = Stream.of(data.getPackageThemes().split(","))
                    .map(String::toString)
                    .collect(Collectors.toList());
            packageDetails.setPackageThemes(packageThemes);
        }

        if(data.getTourIncludes() != null){
            List<String> tourIncludes = Stream.of(data.getTourIncludes().split(","))
                    .map(String::toString)
                    .collect(Collectors.toList());
            packageDetails.setTourIncludes(tourIncludes);
        }

        packageDetails.setPackageRates(getPackageRatesByPackageId(data.getPackageId()));
        packageDetails.setItineraries(getItineraryDetailsByPackageId(data.getPackageId()));
        packageDetails.setTourInformation(getTourInformationByPackageId(data.getPackageId()));
        packageDetails.setTourDetails(getTourDetailsByPackageId(data.getPackageId()));
        packageDetails.setStatus(Status.valueOf(data.getStatus()));
        packageDetails.setCreatedAt(data.getCreatedAt());
        packageDetails.setUpdatedAt(data.getUpdatedAt());




        detailResponse.setPackageDetails(packageDetails);


        return detailResponse;
    }

    private Map<CityVO, List<Date>> getDepartureCityDateMappingsByPackageId(BigInteger packageId) {

        return null;
    }

    private TourDetailsVO getTourDetailsByPackageId(BigInteger packageId) {

        TourDetailsVO tourDetailsVO = new TourDetailsVO();
        tourDetailsVO.setFlightDetails(getFlightDetailsByPackageId(packageId));
        tourDetailsVO.setAccommodationDetails(getAccommodationDetailsByPackageId(packageId));
        tourDetailsVO.setReportingAndDroppingVOS(getReportingAndDroppingDetailsByPackageId(packageId));

        return tourDetailsVO;
    }

    private List<ReportingAndDroppingVO> getReportingAndDroppingDetailsByPackageId(BigInteger packageId) {

        List<ReportingAndDroppingDetail> dataList = reportingAndDroppingDao.getByPackageId(packageId);
        List<ReportingAndDroppingVO> responseList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(dataList)){
            for (ReportingAndDroppingDetail data : dataList){
                ReportingAndDroppingVO dataVO = new ReportingAndDroppingVO();
                dataVO.setId(data.getId());
                dataVO.setPackageId(data.getPackageId());
                dataVO.setGuestType(data.getGuestType());
                dataVO.setDroppingPoint(data.getDroppingPoint());
                dataVO.setReportingPoint(data.getReportingPoint());
                dataVO.setStatus(Status.valueOf(data.getStatus()));
                dataVO.setCreatedAt(data.getCreatedAt());
                dataVO.setUpdatedAt(data.getUpdatedAt());
                responseList.add(dataVO);
            }
        }
        return responseList;
    }

    private List<AccommodationDetailVO> getAccommodationDetailsByPackageId(BigInteger packageId) {

        List<AccommodationDetails> accommodationDetailList = accommodationDetailDao.getByPackageId(packageId);
        List<AccommodationDetailVO> responseList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(accommodationDetailList)){
            for (AccommodationDetails data : accommodationDetailList){
                AccommodationDetailVO detailVO = new AccommodationDetailVO();
                detailVO.setId(data.getId());
                detailVO.setPackageId(data.getPackageId());
                List<CityVO> cityList = getCityDetailsByCityIds(Arrays.asList(data.getCityId()));
                if(!CollectionUtils.isEmpty(cityList)) {
                    detailVO.setCity(cityList.get(0));
                }
                detailVO.setCheckInDate(data.getCheckInDate());
                detailVO.setCheckOutDate(data.getCheckOutDate());
                detailVO.setStatus(Status.valueOf(data.getStatus()));
                detailVO.setCreatedAt(data.getCreatedAt());
                detailVO.setUpdatedAt(data.getUpdatedAt());
                responseList.add(detailVO);
            }
        }
        return responseList;
    }

    private List<FlightDetailVO> getFlightDetailsByPackageId(BigInteger packageId) {

        List<FlightDetails> dataList = flightDetailDao.getByPackageId(packageId);
        List<FlightDetailVO> responseList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(dataList)){
            for (FlightDetails data : dataList){
                FlightDetailVO flightDetailVO = new FlightDetailVO();
                flightDetailVO.setId(data.getId());
                flightDetailVO.setFlightName(data.getFlightName());
                flightDetailVO.setDepartureDate(data.getDepartureDate());
                flightDetailVO.setArrivalDate(data.getArrivalDate());

                List<CityVO> arrivalCities = getCityDetailsByCityIds(Arrays.asList(data.getArrivalCityId()));
                if(!CollectionUtils.isEmpty(arrivalCities)) {
                    flightDetailVO.setArrivalCity(arrivalCities.get(0));
                }

                List<CityVO> depCities = getCityDetailsByCityIds(Arrays.asList(data.getDepartureCityId()));
                if(!CollectionUtils.isEmpty(depCities)) {
                    flightDetailVO.setDepartureCity(depCities.get(0));
                }
                flightDetailVO.setStatus(Status.valueOf(data.getStatus()));
                flightDetailVO.setCreatedAt(data.getCreatedAt());
                flightDetailVO.setUpdatedAt(data.getUpdatedAt());
                responseList.add(flightDetailVO);
            }
        }

        return responseList;
    }

    private List<TourInformationVO> getTourInformationByPackageId(BigInteger packageId) {

        List<TourInformation> dataList = tourInformationDao.getByPackageId(packageId);
        List<TourInformationVO> responseList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(dataList)){
            for (TourInformation tourInformation : dataList){
                TourInformationVO informationVO = new TourInformationVO();
                informationVO.setId(tourInformation.getId());
                informationVO.setInformationType(TourInformationEnum.valueOf(tourInformation.getInformationType()));
                informationVO.setPackageId(tourInformation.packageId);
                informationVO.setDescription(tourInformation.description);
                informationVO.setStatus(Status.valueOf(tourInformation.getStatus()));
                informationVO.setCreatedAt(tourInformation.getCreatedAt());
                informationVO.setUpdatedAt(tourInformation.getUpdatedAt());
                responseList.add(informationVO);
            }
        }
        return responseList;
    }

    private List<PackageItineraryVO> getItineraryDetailsByPackageId(BigInteger packageId) {

        List<PackageItinerary> dataList = packageItineraryDao.getByPackageId(packageId);
        List<PackageItineraryVO> packageItineraryVOList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(dataList)){
            for (PackageItinerary data : dataList) {
                PackageItineraryVO packageItineraryVO = new PackageItineraryVO();
                packageItineraryVO.setId(data.getId());
                packageItineraryVO.setPackageId(data.getPackageId());
                packageItineraryVO.setItineraryTitle(data.getItineraryTitle());
                packageItineraryVO.setItineraryImages(Arrays.asList( data.getItineraryImages().split("\\s*,\\s*")));
                packageItineraryVO.setItineraryDate(data.getItineraryDate());

                List<BigInteger> cityIds = Stream.of(data.getCityIds().split(","))
                        .map(BigInteger::new)
                        .collect(Collectors.toList());
                packageItineraryVO.setCities(getCityDetailsByCityIds(cityIds));
                packageItineraryVO.setDescription(data.getDescription());
                packageItineraryVO.setNote(data.getNote());
                packageItineraryVO.setDayCount(data.dayCount);
                packageItineraryVO.setItineraryAddons(getItineraryAddonsByItineraryId(data.getId()));
                packageItineraryVO.setStatus(Status.valueOf(data.getStatus()));
                packageItineraryVO.setCreatedAt(data.getCreatedAt());
                packageItineraryVO.setUpdatedAt(data.getUpdatedAt());
                packageItineraryVOList.add(packageItineraryVO);
            }

        }
        return packageItineraryVOList;
    }

    private List<CityVO> getCityDetailsByCityIds(List<BigInteger> cityIds) {

        List<City> cityList = cityDao.getByIds(cityIds);
        List<CityVO> cityVOList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(cityList)){
            for (City city : cityList){
                CityVO cityVO = new CityVO();
                cityVO.setId(city.getId());
                cityVO.setName(city.getName());
                cityVO.setCityCode(city.getCityCode());
                cityVO.setState(getStateDetailsByStateId(city.getStateId()));
                cityVO.setStatus(Status.valueOf(city.getStatus()));
                cityVO.setCreatedAt(city.getCreatedAt());
                cityVO.setUpdatedAt(city.getUpdatedAt());
                cityVOList.add(cityVO);
            }
        }
        return cityVOList;
    }

    private StateVO getStateDetailsByStateId(BigInteger stateId) {

        State state = stateDao.getByStateId(stateId);
        StateVO stateVO = new StateVO();
        stateVO.setId(state.getId());
        stateVO.setName(state.getName());
        stateVO.setStateCode(state.getStateCode());
        stateVO.setCountry(getCountryDetailsById(state.getCountryId()));
        stateVO.setStatus(Status.valueOf(state.getStatus()));
        stateVO.setCreatedAt(state.getCreatedAt());
        stateVO.setUpdatedAt(state.getUpdatedAt());
        return stateVO;
    }

    private CountryVO getCountryDetailsById(BigInteger countryId) {

        Country country = countryDao.getById(countryId);
        CountryVO countryVO = new CountryVO();
        countryVO.setId(country.getId());
        countryVO.setName(country.getName());
        countryVO.setCountryCode(country.getCountryCode());
        countryVO.setStatus(Status.valueOf(country.getStatus()));
        countryVO.setCreatedAt(country.getCreatedAt());
        countryVO.setUpdatedAt(country.getUpdatedAt());

        return countryVO;
    }

    private List<PackageItineraryAddons> getItineraryAddonsByItineraryId(BigInteger itineraryId) {

        List<PackageItineraryAddon> dataList = packageItineraryAddonDao.getByItineraryId(itineraryId);
        List<PackageItineraryAddons> responseList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(dataList)){
            for (PackageItineraryAddon data : dataList){
                PackageItineraryAddons addons = new PackageItineraryAddons();
                addons.setId(data.getId());
                addons.setPackageItineraryId(data.getPackageItineraryId());
                addons.setItineraryAddonType(PackageItineraryAddonTypeEnum.valueOf(data.getAddonType()));
                addons.setDescription(data.getDescription());
                addons.setStatus(Status.valueOf(data.getStatus()));
                addons.setCreatedAt(data.getCreatedAt());
                addons.setUpdatedAt(data.getUpdatedAt());
                responseList.add(addons);
            }
        }
        return responseList;
    }

    private List<PackageRateVO> getPackageRatesByPackageId(BigInteger packageId) {

        List<PackageRates> data = packageRateDao.getByPackageId(packageId);
        List<PackageRateVO> responseData = new ArrayList<>();

        if(!CollectionUtils.isEmpty(data)){
            for (PackageRates  rates : data) {
                PackageRateVO packageRateVO = new PackageRateVO();
                packageRateVO.setId(rates.getId());
                packageRateVO.setPackageId(rates.getPackageId());
                packageRateVO.setPackageRateType(PackageRateTypeEnum.valueOf(rates.getPackageRateType()));
                packageRateVO.setGuestSharingType(GuestSharingTypeEnum.valueOf(rates.getGuestSharingType()));
                packageRateVO.setAdultRate(rates.getAdultRate());
                packageRateVO.setChildRateWithBed(rates.getChildRateWithBed());
                packageRateVO.setChildRateWithoutBed(rates.getChildRateWithoutBed());
                packageRateVO.setInfantRate(rates.getInfantRate());
                packageRateVO.setStatus(Status.valueOf(rates.getStatus()));
                packageRateVO.setCreatedAt(rates.getCreatedAt());
                packageRateVO.setUpdatedAt(rates.getUpdatedAt());
                responseData.add(packageRateVO);
            }
        }
        return responseData;
    }
}
