package com.LQB12;

import java.util.Objects;

/**
 * @auther wuqiong
 * @date 2021/12/9
 * @time 18:40
 * @description
 */
public class Test {

    double a;
    double b;

    public Test(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Double.compare(test.a, a) == 0 && Double.compare(test.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
