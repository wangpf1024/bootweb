package com.controller.bootweb.demo.dsa;

import java.util.Arrays;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class ClosestPair {

    // 计算两点之间的距离(欧几里得距离)
    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // 递归求解最近点对
    private static double closestPair(Point[] points, int left, int right) {
        if (right - left <= 3) {
            // 对于小规模问题，使用暴力方法解决
            double minDist = Double.POSITIVE_INFINITY;
            for (int i = left; i < right; i++) {
                for (int j = i + 1; j < right; j++) {
                    minDist = Math.min(minDist, distance(points[i], points[j]));
                }
            }
            return minDist;
        }

        // 分成两半
        int mid = (left + right) / 2;
        double leftDist = closestPair(points, left, mid);
        double rightDist = closestPair(points, mid, right);
        double minDist = Math.min(leftDist, rightDist);

        // 查找中间带有 d 距离的带区域
        Point[] strip = new Point[right - left];
        int stripSize = 0;
        for (int i = left; i < right; i++) {
            if (Math.abs(points[i].x - points[mid].x) < minDist) {
                strip[stripSize++] = points[i];
            }
        }

        // 根据 y 坐标排序带区域内的点
        Arrays.sort(strip, 0, stripSize, (p1, p2) -> Double.compare(p1.y, p2.y));

        // 查找带区域内更小的距离
        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && strip[j].y - strip[i].y < minDist; j++) {
                minDist = Math.min(minDist, distance(strip[i], strip[j]));
            }
        }

        return minDist;
    }

    // 计算最近点对的距离
    public static double closestPair(Point[] points) {
        if (points == null || points.length < 2) {
            return Double.POSITIVE_INFINITY;
        }

        // 按照 x 坐标排序
        Arrays.sort(points, (p1, p2) -> Double.compare(p1.x, p2.x));

        return closestPair(points, 0, points.length);
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(5, 5),
                new Point(7, 7)};
        double closestDistance = closestPair(points);
        System.out.println("最近点对的距离：" + closestDistance);
    }
}

