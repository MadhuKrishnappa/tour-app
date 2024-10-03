package com.tour.app.das;

import com.tour.app.entity.ReportingAndDroppingDetail;

import java.math.BigInteger;
import java.util.List;

public interface IReportingAndDroppingDao {
    ReportingAndDroppingDetail add(ReportingAndDroppingDetail reportingAndDroppingDetail);

    List<ReportingAndDroppingDetail> getByPackageId(BigInteger packageId);
}
