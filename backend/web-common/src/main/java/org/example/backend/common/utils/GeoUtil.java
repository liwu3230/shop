package org.example.backend.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.dto.business.AppUserDto;
import org.example.backend.common.model.dto.business.Point;
import org.example.backend.common.model.dto.business.StoreDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/13 17:24
 */
@Slf4j
public class GeoUtil {

    private static final double EARTH_RADIUS1 = 6371000;

    /**
     * 转化为弧度(rad)
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double calcDist(double lat1, double lon1, double lat2, double lon2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS1;
        s = (double) Math.round(s * 10000) / 10000;
        return s;
    }

//    public static double calcDist(double srcLatitude, double srcLongitude, double dstLatitude, double dstLongitude) {
//        Vector2D sourceVector = new Vector2D(srcLatitude, srcLongitude);
//        Vector2D targetVector = new Vector2D(dstLatitude, dstLongitude);
//
//        return sourceVector.distance(targetVector);
//    }

    public static List<AppUserDto> sortUserByDist(double srcLatitude, double srcLongitude, List<AppUserDto> appUserList) {
        List<AppUserDto> sortedList = new ArrayList<>(appUserList);

        for (AppUserDto dto : sortedList) {
            Point point = dto.getPoint();
            if (point != null) {
                double dist = calcDist(srcLatitude, srcLongitude, point.getLatitude(), point.getLongitude());
                dto.setDistance(dist);
            }
        }
        sortedList.sort(Comparator.comparingDouble(AppUserDto::getDistance));
        return sortedList;
    }

    public static List<StoreDto> sortStoreByDist(AppUserDto appUserDto, List<StoreDto> storeList) {
        List<StoreDto> sortedList = new ArrayList<>(storeList);
        if (appUserDto.getPoint() != null) {
            double srcLatitude = appUserDto.getPoint().getLatitude();
            double srcLongitude = appUserDto.getPoint().getLongitude();
            for (StoreDto dto : sortedList) {
                double dist = calcDist(srcLatitude, srcLongitude, T.parse(dto.getLatitude(), 0d), T.parse(dto.getLongitude(), 0d));
                dto.setDistance(dist);
            }
        }
        sortedList.sort(Comparator.comparingDouble(StoreDto::getDistance));
        return sortedList;
    }

}
