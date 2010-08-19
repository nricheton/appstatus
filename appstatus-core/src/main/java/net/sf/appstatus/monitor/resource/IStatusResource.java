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
package net.sf.appstatus.monitor.resource;

import net.sf.appstatus.IStatusResult;
import net.sf.appstatus.monitor.IStatusResourceMonitor;

/**
 * Describe the status of a generic resource.
 * 
 * @author Guillaume Mary
 * 
 */
public interface IStatusResource {

	/**
	 * Return the resource monitor.
	 * 
	 * @return the resource monitor
	 */
	IStatusResourceMonitor getMonitor();

	/**
	 * Return the resource name.
	 * 
	 * @return the resource name
	 */
	String getName();

	/**
	 * Return the status of this resource.
	 * 
	 * @return the status of this resource.
	 */
	IStatusResult getStatus();

	/**
	 * Resource type.
	 * 
	 * @return the resource type
	 */
	String getType();
}
