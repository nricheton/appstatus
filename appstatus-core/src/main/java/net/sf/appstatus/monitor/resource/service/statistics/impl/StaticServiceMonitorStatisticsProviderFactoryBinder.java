/*
 * Copyright 2010 Capgemini
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 */
package net.sf.appstatus.monitor.resource.service.statistics.impl;

import net.sf.appstatus.monitor.resource.service.statistics.IServiceMonitorStatisticsProviderFactory;
import net.sf.appstatus.monitor.resource.service.statistics.spi.IServiceMonitorStatisticsProviderFactoryBinder;

/**
 * Dummy binder use to compile. Should be excluded.
 * 
 * @author Guillaume Mary
 * 
 */
public class StaticServiceMonitorStatisticsProviderFactoryBinder implements
		IServiceMonitorStatisticsProviderFactoryBinder {

	/**
	 * The unique instance of this class.
	 * 
	 */
	private static final StaticServiceMonitorStatisticsProviderFactoryBinder SINGLETON = new StaticServiceMonitorStatisticsProviderFactoryBinder();

	/**
	 * Return the singleton of this class.
	 * 
	 * @return the StaticServiceMonitorStatisticsProviderFactoryBinder singleton
	 */
	public static final StaticServiceMonitorStatisticsProviderFactoryBinder getSingleton() {
		return SINGLETON;
	}

	private StaticServiceMonitorStatisticsProviderFactoryBinder() {
		throw new UnsupportedOperationException(
				"This code should have never made it into the jar");
	}

	/**
	 * {@inheritDoc}
	 */
	public IServiceMonitorStatisticsProviderFactory getServiceMonitorStatisticsProviderFactory() {
		throw new UnsupportedOperationException(
				"This code should never make it into the jar");
	}

	/**
	 * {@inheritDoc}
	 */
	public String getServiceMonitorStatisticsProviderFactoryStr() {
		throw new UnsupportedOperationException(
				"This code should never make it into the jar");
	}

}