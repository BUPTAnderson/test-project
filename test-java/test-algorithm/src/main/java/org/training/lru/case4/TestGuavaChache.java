package org.training.lru.case4;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by Anderson on 2019/6/21
 * LinkedHashMap是非线程安全的，如果要线程安全，使用guava cache
 */
public class TestGuavaChache {
    public static void main(String[] args) {
//        Cache<String, Integer> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(3, TimeUnit.SECONDS).build();


        LoadingCache<String, Optional<Integer>> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(new CacheLoader<String, Optional<Integer>>() {
                    @Override
                    public Optional<Integer> load(String s) throws Exception {
                        throw new IOException("not found");
                    }
                });

        try {
//            cache.get("1", new Callable<Optional<Integer>>() {
//                @Override
//                public Optional<Integer> call() throws Exception {
//                    return Optional.of(1);
//                }
//            });
//            cache.get("2", new Callable<Optional<Integer>>() {
//                @Override
//                public Optional<Integer> call() throws Exception {
//                    return Optional.of(2);
//                }
//            });
//            cache.get("3", new Callable<Optional<Integer>>() {
//                @Override
//                public Optional<Integer> call() throws Exception {
//                    return Optional.of(3);
//                }
//            });
//            cache.get("4", new Callable<Optional<Integer>>() {
//                @Override
//                public Optional<Integer> call() throws Exception {
//                    return Optional.of(4);
//                }
//            });
//
//            cache.get("3", new Callable<Optional<Integer>>() {
//                @Override
//                public Optional<Integer> call() throws Exception {
//                    return Optional.of(3);
//                }
//            });
//            cache.get("5", new Callable<Optional<Integer>>() {
//                @Override
//                public Optional<Integer> call() throws Exception {
//                    return Optional.of(5);
//                }
//            });
//            cache.get("6", new Callable<Optional<Integer>>() {
//                @Override
//                public Optional<Integer> call() throws Exception {
//                    return Optional.of(6);
//                }
//            });
//            cache.get("3", new Callable<Optional<Integer>>() {
//                @Override
//                public Optional<Integer> call() throws Exception {
//                    return Optional.of(3);
//                }
//            });
            ////////////////////////////////
            try {
                Optional<Integer> result = cache.get("1");
//                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                cache.put("1", Optional.of(1));
            }
            try {
                Optional<Integer> result = cache.get("2");
//                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                cache.put("2", Optional.of(2));
            }
            try {
                Optional<Integer> result = cache.get("3");
//                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                cache.put("3", Optional.of(3));
            }
            try {
                Optional<Integer> result = cache.get("4");
//                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                cache.put("4", Optional.of(4));
            }
            try {
                Optional<Integer> result = cache.get("3");
//                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                cache.put("3", Optional.of(3));
            }
            try {
                Optional<Integer> result = cache.get("5");
//                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                cache.put("5", Optional.of(5));
            }
            try {
                Optional<Integer> result = cache.get("6");
//                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                cache.put("6", Optional.of(6));
            }
            try {
                Optional<Integer> result = cache.get("3");
//                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                cache.put("3", Optional.of(3));
            }

            //////////////////////////////
            try {
                Optional<Integer> result = cache.get("1");
                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                System.out.println("1 not exist");
            }
            try {
                Optional<Integer> result = cache.get("2");
                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                System.out.println("2 not exist");
            }
            try {
                Optional<Integer> result = cache.get("3");
                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                System.out.println("3 not exist");
            }
            try {
                Optional<Integer> result = cache.get("4");
                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                System.out.println("4 not exist");
            }
            try {
                Optional<Integer> result = cache.get("5");
                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                System.out.println("5 not exist");
            }
            try {
                Optional<Integer> result = cache.get("6");
                System.out.println(result.isPresent() ? result.get() : null);
            } catch (Exception e) {
                System.out.println("6 not exist");
            }
            if (false) {
                throw new ExecutionException(new IOException(""));
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
