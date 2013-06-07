package com.mortardata.api.v2;

import java.util.HashMap;

public class JobRequest {

    private String projectName;
    private String scriptName;
    private String gitRef;
    private int clusterSize;
    private boolean notifyOnJobFinish = true;
    private Jobs.ClusterType clusterType = Jobs.ClusterType.PERSISTENT;
    private HashMap parameters = new HashMap();
    private boolean isControlScript = false;
    private String clusterId;

    public JobRequest(String projectName, String scriptName, String gitRef, int clusterSize) {
        this.projectName = projectName;
        this.scriptName = scriptName;
        this.gitRef = gitRef;
        this.clusterSize = clusterSize;
    }

    public JobRequest(String projectName, String scriptName, String gitRef, String clusterId) {
        this.projectName = projectName;
        this.scriptName = scriptName;
        this.gitRef = gitRef;
        this.clusterId = clusterId;
    }

    public HashMap<String, Object> getArguments() {
        HashMap<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("project_name", projectName);
        arguments.put("git_ref", gitRef);
        if (clusterId != null) {
            arguments.put("cluster_id", clusterId);
        } else {
            arguments.put("cluster_type", clusterType.getReturnString());
            arguments.put("cluster_size", clusterSize);
        }
        arguments.put("parameters", parameters);
        arguments.put("notify_on_job_finish", notifyOnJobFinish);
        if (isControlScript) {
            arguments.put("controlscript_name", scriptName);
        } else {
            arguments.put("pigscript_name", scriptName);
        }
        return arguments;
    }

    public boolean isNotifyOnJobFinish() {
        return notifyOnJobFinish;
    }

    public void setNotifyOnJobFinish(boolean notifyOnJobFinish) {
        this.notifyOnJobFinish = notifyOnJobFinish;
    }

    public Jobs.ClusterType getClusterType() {
        return clusterType;
    }

    public void setClusterType(Jobs.ClusterType clusterType) {
        this.clusterType = clusterType;
    }

    public HashMap getParameters() {
        return parameters;
    }

    public void setParameters(HashMap parameters) {
        this.parameters = parameters;
    }

    public boolean isControlScript() {
        return isControlScript;
    }

    public void setControlScript(boolean controlScript) {
        isControlScript = controlScript;
    }

    public String getClusterId() {
        return clusterId;
    }

    public int getClusterSize() {
        return clusterSize;
    }

    public String getGitRef() {
        return gitRef;
    }

    public String getScriptName() {
        return scriptName;
    }

    public String getProjectName() {
        return projectName;
    }
}
