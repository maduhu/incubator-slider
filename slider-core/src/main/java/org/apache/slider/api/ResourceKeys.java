/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.slider.api;

/**
 * These are the keys valid in resource options
 *
 /*

 Container failure window.

 The window is calculated in minutes as as (days * 24 *60 + hours* 24 + minutes)

 Every interval of this period after the AM is started/restarted becomes
 the time period in which the CONTAINER_FAILURE_THRESHOLD value is calculated.
 
 After the window limit is reached, the failure counts are reset. This
 is not a sliding window/moving average policy, simply a rule such as
 "every six hours the failure count is reset"


 <pre>
 ===========================================================================
 </pre>

 */
public interface ResourceKeys {


  /**
   * #of instances of a component
   *
  */
  String COMPONENT_INSTANCES = "yarn.component.instances";

  /**
   *  Amount of memory to ask YARN for in MB.
   *  <i>Important:</i> this may be a hard limit on the
   *  amount of RAM that the service can use
   *  {@value}
   */
  String YARN_MEMORY = "yarn.memory";
  
  /** {@value} */
  int DEF_YARN_MEMORY = 256;
  
  /**
   * Number of cores/virtual cores to ask YARN for
   *  {@value}
   */
  String YARN_CORES = "yarn.vcores";
  
  /** {@value} */
  int DEF_YARN_CORES = 1;
  
  /**
   * Constant to indicate that the requirements of a YARN resource limit
   * (cores, memory, ...) should be set to the maximum allowed by
   * the queue into which the YARN container requests are placed.
   */
  String YARN_RESOURCE_MAX = "max";
  
  /**
   * Mandatory property for all roles
   * 1. this must be defined.
   * 2. this must be >= 1
   * 3. this must not match any other role priority in the cluster.
   */
  String COMPONENT_PRIORITY = "yarn.role.priority";
  
  /**
   * placement policy
   */
  String COMPONENT_PLACEMENT_POLICY = "yarn.component.placement.policy";

  

  /**
   * Time in seconds before a container is considered long-lived.
   * Shortlived containers are interpreted as a problem with the role
   * and/or the host: {@value}
   */
  String CONTAINER_FAILURE_SHORTLIFE =
      "container.failure.shortlife";

  /**
   * Default short life threshold: {@value}
   */
  int DEFAULT_CONTAINER_FAILURE_SHORTLIFE = 60;

  /**
   * maximum number of failed containers (in a single role)
   * before the cluster is deemed to have failed {@value}
   */
  String CONTAINER_FAILURE_THRESHOLD =
      "yarn.container.failure.threshold";

  /**
   * Minutes range of the container failure reset window.
   * This is combined with the hour and day values to
   * produce the full window.
   * {@value}
   */
  String CONTAINER_FAILURE_WINDOW_MINUTES =
      "yarn.container.failure.window.minutes";

  
  
  /**
   * Hours range of the container failure reset window
   * This is combined with the minute and day values to
   * produce the full window.
   * {@value}
   */
  String CONTAINER_FAILURE_WINDOW_HOURS =
      "yarn.container.failure.window.hours";


  /**
   * Hours range of the container failure reset window
   * This is combined with the hour and minute values to
   * produce the full window.
   * {@value}
   */
  String CONTAINER_FAILURE_WINDOW_DAYS =
      "yarn.container.failure.window.days";

  int DEFAULT_CONTAINER_FAILURE_WINDOW_DAYS = 0;
  int DEFAULT_CONTAINER_FAILURE_WINDOW_HOURS = 6;
  int DEFAULT_CONTAINER_FAILURE_WINDOW_MINUTES = 0;


  /**
   * Default failure threshold: {@value}
   */
  int DEFAULT_CONTAINER_FAILURE_THRESHOLD = 5;

}
