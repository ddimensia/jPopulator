/*
 * The MIT License
 *
 *   Copyright (c) 2015, Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */

package io.github.benas.jpopulator.randomizers.range;

import java.util.Date;

/**
 * A custom date randomizer that generates random dates in a range of date values.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class DateRangeRandomizer extends AbstractRangeRandomizer<Date> {
    /**
     * Public constructor.
     *
     * @param min the minimum date.
     * @param max the maximum date.
     */
    public DateRangeRandomizer(final Date min, final Date max) {
        super(min, max);
    }

    @Override
    protected void checkValues() {
        if (min.after(max)) throw new IllegalArgumentException("max must be after min");
    }

    @Override
    protected Date getDefaultMinValue() {
        return new Date(Long.MIN_VALUE);
    }

    @Override
    protected Date getDefaultMaxValue() {
        return new Date(Long.MAX_VALUE);
    }

    @Override
    public Date getRandomValue() {
        long minDateTime = min.getTime();
        long maxDateTime = max.getTime();
        long randomDateTime = randomDataGenerator.nextLong(minDateTime, maxDateTime);
        return new Date(randomDateTime);
    }

}
