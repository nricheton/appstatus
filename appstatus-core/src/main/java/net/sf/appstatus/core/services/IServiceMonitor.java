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
package net.sf.appstatus.core.services;

import org.slf4j.Logger;

/**
 * Service monitor
 *
 * @author Guillaume Mary
 * @author Nicolas Richeton
 *
 */
public interface IServiceMonitor {

	/**
	 * Notify of the beginning of a call to a service.
	 *
	 * @param operationName
	 *            operation name
	 * @param parameters
	 *            operation parameters
	 * @return call id
	 */
	void beginCall(Object... parameters);

	/**
	 * Reports that a cache system was used instead of performing the actual
	 * call.
	 *
	 */
	void cacheHit();

	void context(String name, String value);

	void correlationId(String correlationId);

	/**
	 * Notify the end of a call to a service.
	 *
	 */
	void endCall();

	/**
	 * Reports an error : the call has succeed but returns an error (with data).
	 *
	 * @param message
	 */
	void error(String message);

	/**
	 * Manually set the execution time. If this method is not called, execution
	 * time is computed between beginCall and endCall.
	 */
	void executionTime(long timeMillis);

	/**
	 * Reports a failure : the call has failed completely
	 *
	 * @param reason
	 */
	void failure(String reason);

	/**
	 * Reports a failure : the call has failed completely with exception e.
	 *
	 * @param reason
	 * @param e
	 */
	void failure(String reason, Exception e);

	/**
	 * Report that another service was called in order to perform original
	 * action
	 */
	void nestedCall();

	/**
	 * Set the log message format for this monitor instance, based on :
	 * http://commons.apache.org/lang/api-release/org/apache/commons/lang3/text/
	 * StrSubstitutor.html
	 *
	 * <p>
	 * Example :
	 * <code>${correlationId}|${group}|${name}|${responseTime}|${cache}|${status}|${statusMessage}</code>
	 * </p>
	 *
	 * <p>
	 * Available variables :
	 * </p>
	 * <ul>
	 * <li>group</li>
	 * <li>name</li>
	 * <li>responseTime</li>
	 * <li>cache</li>
	 * <li>failure</li>
	 * <li>failureReason</li>
	 * <li>failureException</li>
	 * <li>error</li>
	 * <li>errorMessage</li>
	 * <li>correlationId</li>
	 * <li>status : SUCCESS/FAILURE/ERROR</li>
	 * <li>statusMessage : failure or error message</li>
	 * <li>Any additional context values</li>
	 * </ul>
	 *
	 * @param format
	 */
	void setLogFormat(String format);

	/**
	 * Set the logger to use for this service call.
	 *
	 * @param logger
	 */
	void setLogger(Logger logger);

}
