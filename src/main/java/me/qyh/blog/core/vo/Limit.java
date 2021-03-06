/*
 * Copyright 2016 qyh.me
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.qyh.blog.core.vo;

import java.util.concurrent.TimeUnit;

/**
 * 在指定时间内最多能执行limit次操作
 * 
 * @author Administrator
 *
 */
public class Limit {

	private int count;
	private long time;
	private TimeUnit unit;

	/**
	 * default
	 */
	public Limit() {
		super();
	}

	/**
	 * 
	 * @param count
	 *            最大数目
	 * @param time
	 *            时间
	 * @param unit
	 *            时间单位
	 */
	public Limit(int count, long time, TimeUnit unit) {
		this.count = count;
		this.time = time;
		this.unit = unit;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public TimeUnit getUnit() {
		return unit;
	}

	public void setUnit(TimeUnit unit) {
		this.unit = unit;
	}

	public long toMill() {
		return unit.toMillis(time);
	}
}
