package com.controller.bootweb.demo.dsa;


import java.util.concurrent.ConcurrentHashMap;

public class SingleFlight {
    private final ConcurrentHashMap<String, Result> resultMap = new ConcurrentHashMap<>();

    public interface Callable<T> {
        T call() throws InterruptedException;
    }

    public static class Result<T> {
        private final T value;
        private final Throwable error;

        public Result(T value, Throwable error) {
            this.value = value;
            this.error = error;
        }

        public T getValue() {
            return value;
        }

        public Throwable getError() {
            return error;
        }
    }

    public <T> Result<T> doOnce(String key, Callable<T> fn) {
        Result<T> result = new Result<>(null, null);

        Result<T> existingResult = resultMap.putIfAbsent(key, result);

        if (existingResult != null) {
            return existingResult;
        }

        try {
            T value = fn.call();
            result = new Result<>(value, null);
        } catch (Exception e) {
            result = new Result<>(null, e);
        } finally {
            resultMap.remove(key, result);
        }

        return result;
    }

    public static void main(String[] args) {
        SingleFlight singleflight = new SingleFlight();

        Callable<String> fn = () -> {
            // Simulate some expensive computation
            Thread.sleep(2000);
            return "Result of computation";
        };

        String key = "computation_key";

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Result<String> result = singleflight.doOnce(key, fn);
                if (result.getError() != null) {
                    System.out.println("Error: " + result.getError().getMessage());
                } else {
                    System.out.println("Result: " + result.getValue());
                }
            }).start();
        }
    }
}
