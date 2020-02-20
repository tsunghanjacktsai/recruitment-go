import request from "@/utils/request";
import qs from "qs";

export default {
  getResumeByResumeid(resumeid) {
    return request({
      url: "/resume/" + resumeid,
      method: "get"
    });
  },
  getMyResume() {
    return request({
      url: "resume/my-resume",
      method: "get"
    });
  },
  getAllResumes() {
    return request({
      url: "/resume/get-all-resumes",
      method: "get"
    });
  },
  manageResume(
    resumeid,
    mail,
    name,
    phone,
    location,
    intention,
    website,
    statement,
    school,
    major,
    edustart,
    eduend,
    edudescript,
    jobs
  ) {
    return request({
      url: "/resume/manage-resume/" + resumeid,
      method: "put",
      data: qs.stringify(
        {
          mail: mail,
          name: name,
          phone: phone,
          location: location,
          intention: intention,
          website: website,
          statement: statement,
          school: school,
          major: major,
          edustart: edustart,
          eduend: eduend,
          edudescript: edudescript,
          jobs: JSON.stringify(jobs)
        },
        {
          indices: false
        }
      )
    });
  },
  getResumeByApplicationid(applicationid) {
    return request({
      url: "/resume/get-resume-by-applicationid/" + applicationid,
      method: "get"
    });
  }
};
