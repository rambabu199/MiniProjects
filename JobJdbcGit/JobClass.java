package com.bitlabs.jobportaljdbc;

public class JobClass {
	private String companyname;
    private int jobid;
    private String jobrole; 
    private String qualification;
    private String keyskill;
    private String location;
    private float experience;
    private String postdate;
    private String type_of_job;
    private String domain;
    private String job_description;

    public JobClass(int jobid,String companyname, String jobrole,String job_description, String qualification, String keyskill, String location,
            float experience, String postdate, String type_of_job, String domain) {
        this.jobid = jobid;
        this.companyname = companyname;
        this.jobrole = jobrole;
        this.job_description=job_description;
        this.qualification = qualification;
        this.keyskill = keyskill;
        this.location = location;
        this.experience = experience;
        this.postdate = postdate;
        this.type_of_job = type_of_job;
        this.domain = domain;
    }
    public JobClass() {
		// TODO Auto-generated constructor stub
	}
	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
    public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void setKeyskill(String keyskill) {
		this.keyskill = keyskill;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public void setType_of_job(String type_of_job) {
		this.type_of_job = type_of_job;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCompanyname() {
        return companyname;
    }

    public int getJobid() {
        return jobid;
    }

    public String getJobrole() {
        return jobrole;
    }

    public String getQualification() {
        return qualification;
    }

    public String getKeyskill() {
        return keyskill;
    }

    public String getLocation() {
        return location;
    }

    public float getExperience() {
        return experience;
    }

    public String getPostdate() {
        return postdate;
    }

    public String getType_of_job() {
        return type_of_job;
    }

    public String getDomain() {
        return domain;
    }

    public String toString() {
        return "Company Name: " + companyname + "\nJob ID: " + jobid + "\nJob Role: " + jobrole +"job_description"+job_description+ "\nQualification: "
                + qualification + "\nKey Skill: " + keyskill + "\nLocation: " + location + "\nExperience: "
                + experience + "\nPost Date: " + postdate + "\nType of Job: " + type_of_job + "\nDomain: " + domain;
    }


}
