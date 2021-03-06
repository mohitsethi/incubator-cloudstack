// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.api.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cloud.api.ApiConstants;
import com.cloud.api.BaseListAccountResourcesCmd;
import com.cloud.api.IdentityMapper;
import com.cloud.api.Implementation;
import com.cloud.api.Parameter;
import com.cloud.api.response.ListResponse;
import com.cloud.api.response.ProjectResponse;
import com.cloud.exception.InvalidParameterValueException;
import com.cloud.projects.Project;
import com.cloud.utils.Pair;

@Implementation(description="Lists projects and provides detailed information for listed projects", responseObject=ProjectResponse.class, since="3.0.0")
public class ListProjectsCmd extends BaseListAccountResourcesCmd {
    public static final Logger s_logger = Logger.getLogger(ListProjectsCmd.class.getName());
    private static final String s_name = "listprojectsresponse";

    /////////////////////////////////////////////////////
    //////////////// API parameters /////////////////////
    /////////////////////////////////////////////////////
    
    @IdentityMapper(entityTableName="projects")
    @Parameter(name=ApiConstants.ID, type=CommandType.LONG, description="list projects by project ID")
    private Long id;

    @Parameter(name=ApiConstants.NAME, type=CommandType.STRING, description="list projects by name")
    private String name;

    @Parameter(name=ApiConstants.DISPLAY_TEXT, type=CommandType.STRING, description="list projects by display text")
    private String displayText;
    
    @Parameter(name=ApiConstants.STATE, type=CommandType.STRING, description="list projects by state")
    private String state;
    
    @Parameter(name = ApiConstants.TAGS, type = CommandType.MAP, description = "List projects by tags (key/value pairs)")
    private Map tags;
    
    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisplayText() {
        return displayText;
    }
    
    @Override
    public String getCommandName() {
        return s_name;
    }
    
    public Map<String, String> getTags() {
        Map<String, String> tagsMap = null;
        if (tags != null && !tags.isEmpty()) {
            tagsMap = new HashMap<String, String>();
            Collection<?> servicesCollection = tags.values();
            Iterator<?> iter = servicesCollection.iterator();
            while (iter.hasNext()) {
                HashMap<String, String> services = (HashMap<String, String>) iter.next();
                String key = services.get("key");
                String value = services.get("value");
                if (value == null) {
                    throw new InvalidParameterValueException("No value is passed in for key " + key);
                }
                tagsMap.put(key, value);
            }
        }
        return tagsMap;
    }

    /////////////////////////////////////////////////////
    /////////////// API Implementation///////////////////
    /////////////////////////////////////////////////////

    @Override
    public void execute(){
        Pair<List<? extends Project>, Integer> projects = _projectService.listProjects(id, name, displayText, state, 
                this.getAccountName(), this.getDomainId(), this.getKeyword(), this.getStartIndex(), this.getPageSizeVal(),
                this.listAll(), this.isRecursive(), getTags());
        ListResponse<ProjectResponse> response = new ListResponse<ProjectResponse>();
        List<ProjectResponse> projectResponses = new ArrayList<ProjectResponse>();
        for (Project project : projects.first()) {
            ProjectResponse projectResponse = _responseGenerator.createProjectResponse(project);
            projectResponses.add(projectResponse);
        }
        response.setResponses(projectResponses, projects.second());
        response.setResponseName(getCommandName());
        
        this.setResponseObject(response);
    }
}
