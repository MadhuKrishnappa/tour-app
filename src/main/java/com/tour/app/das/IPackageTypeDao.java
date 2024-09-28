package com.tour.app.das;

import com.tour.app.entity.PackageType;
import com.tour.app.model.enums.PackageTypeEnum;

public interface IPackageTypeDao {
    PackageType getByPackageType(PackageTypeEnum packageType);
}
