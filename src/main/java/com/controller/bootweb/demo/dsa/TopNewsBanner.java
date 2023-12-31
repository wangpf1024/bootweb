package com.controller.bootweb.demo.dsa;
import lombok.Data;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.PriorityQueue;
import java.util.Queue;

class News {
    private String title;
    private String summary;
    private int clicks;

    public News(String title, String summary, int clicks) {
        this.title = title;
        this.summary = summary;
        this.clicks = clicks;
    }

    public int getClicks() {
        return clicks;
    }

    // 新增更新点击量的方法
    public void updateClicks(int increment) {
        this.clicks += increment;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", clicks=" + clicks +
                '}';
    }
}


public class TopNewsBanner {

    private static Queue<News> maxHeap = new PriorityQueue<>(Comparator.comparingInt(News::getClicks).reversed());

    public static void main(String[] args) {
        // Initialize sample news
        initializeNews();

        // Schedule the task to update and display top news every hour
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(TopNewsBanner::updateAndDisplayTopNews, 0, 1, TimeUnit.MINUTES);
    }

    private static void initializeNews() {
        // Initialize with sample news data
        maxHeap.add(new News("News 1", "Summary 1", 1000));
        maxHeap.add(new News("News 2", "Summary 2", 800));
        // Add more news items as needed
    }

    private static void updateAndDisplayTopNews() {
        // Update clicks (simulate user clicks)
        updateNewsClicks();

        // Calculate top news
        List<News> topNews = calculateTopNews();

        // Display top news
        displayTopNews(topNews);
    }

    private static void updateNewsClicks() {
        // Simulate updating clicks for each news item (incremental clicks for simplicity)
        for (News news : maxHeap) {
            news.updateClicks((int) (Math.random() * 100)); // Simulate random clicks
        }
    }

    private static List<News> calculateTopNews() {
        // Get top 10 news
        List<News> topNews = new ArrayList<>();
        int count = Math.min(10, maxHeap.size());
        for (int i = 0; i < count; i++) {
            topNews.add(maxHeap.poll());
        }
        topNews.forEach(i-> maxHeap.offer(i));
        return topNews;
    }

    private static void displayTopNews(List<News> topNews) {
        // Display top news in the banner
        System.out.println("Top News Banner:");
        for (News news : topNews) {
            System.out.println(news);
        }
        System.out.println("-----------------------------");
    }
}
