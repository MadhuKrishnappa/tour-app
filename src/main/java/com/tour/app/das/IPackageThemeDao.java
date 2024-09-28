package com.tour.app.das;

import com.tour.app.entity.PackageTheme;
import com.tour.app.model.enums.PackageThemeEnum;

public interface IPackageThemeDao {
    PackageTheme getByPackageTheme(PackageThemeEnum packageTheme);
}
