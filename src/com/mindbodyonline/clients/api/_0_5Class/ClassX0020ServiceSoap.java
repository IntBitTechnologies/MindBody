
package com.mindbodyonline.clients.api._0_5Class;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Class_x0020_ServiceSoap", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClassX0020ServiceSoap {


    /**
     * Gets a list of classes.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.GetClassesResult
     */
    @WebMethod(operationName = "GetClasses", action = "http://clients.mindbodyonline.com/api/0_5/GetClasses")
    @WebResult(name = "GetClassesResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "GetClasses", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetClasses")
    @ResponseWrapper(localName = "GetClassesResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetClassesResponse")
    public GetClassesResult getClasses(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        GetClassesRequest request);

    /**
     * Update a list of visits.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.UpdateClientVisitsResult
     */
    @WebMethod(operationName = "UpdateClientVisits", action = "http://clients.mindbodyonline.com/api/0_5/UpdateClientVisits")
    @WebResult(name = "UpdateClientVisitsResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "UpdateClientVisits", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.UpdateClientVisits")
    @ResponseWrapper(localName = "UpdateClientVisitsResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.UpdateClientVisitsResponse")
    public UpdateClientVisitsResult updateClientVisits(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        UpdateClientVisitsRequest request);

    /**
     * Gets a class with a list of clients.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.GetClassVisitsResult
     */
    @WebMethod(operationName = "GetClassVisits", action = "http://clients.mindbodyonline.com/api/0_5/GetClassVisits")
    @WebResult(name = "GetClassVisitsResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "GetClassVisits", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetClassVisits")
    @ResponseWrapper(localName = "GetClassVisitsResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetClassVisitsResponse")
    public GetClassVisitsResult getClassVisits(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        GetClassVisitsRequest request);

    /**
     * Gets a list of class descriptions.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.GetClassDescriptionsResult
     */
    @WebMethod(operationName = "GetClassDescriptions", action = "http://clients.mindbodyonline.com/api/0_5/GetClassDescriptions")
    @WebResult(name = "GetClassDescriptionsResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "GetClassDescriptions", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetClassDescriptions")
    @ResponseWrapper(localName = "GetClassDescriptionsResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetClassDescriptionsResponse")
    public GetClassDescriptionsResult getClassDescriptions(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        GetClassDescriptionsRequest request);

    /**
     * Gets a list of enrollments.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsResult
     */
    @WebMethod(operationName = "GetEnrollments", action = "http://clients.mindbodyonline.com/api/0_5/GetEnrollments")
    @WebResult(name = "GetEnrollmentsResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "GetEnrollments", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetEnrollments")
    @ResponseWrapper(localName = "GetEnrollmentsResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetEnrollmentsResponse")
    public GetEnrollmentsResult getEnrollments(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        GetEnrollmentsRequest request);

    /**
     * Gets a list of class schedules.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.GetClassSchedulesResult
     */
    @WebMethod(operationName = "GetClassSchedules", action = "http://clients.mindbodyonline.com/api/0_5/GetClassSchedules")
    @WebResult(name = "GetClassSchedulesResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "GetClassSchedules", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetClassSchedules")
    @ResponseWrapper(localName = "GetClassSchedulesResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetClassSchedulesResponse")
    public GetClassSchedulesResult getClassSchedules(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        GetClassSchedulesRequest request);

    /**
     * Adds clients to classes (signup).
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.AddClientsToClassesResult
     */
    @WebMethod(operationName = "AddClientsToClasses", action = "http://clients.mindbodyonline.com/api/0_5/AddClientsToClasses")
    @WebResult(name = "AddClientsToClassesResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "AddClientsToClasses", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.AddClientsToClasses")
    @ResponseWrapper(localName = "AddClientsToClassesResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.AddClientsToClassesResponse")
    public AddClientsToClassesResult addClientsToClasses(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        AddClientsToClassesRequest request);

    /**
     * Removes clients from classes.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.RemoveClientsFromClassesResult
     */
    @WebMethod(operationName = "RemoveClientsFromClasses", action = "http://clients.mindbodyonline.com/api/0_5/RemoveClientsFromClasses")
    @WebResult(name = "RemoveClientsFromClassesResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "RemoveClientsFromClasses", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.RemoveClientsFromClasses")
    @ResponseWrapper(localName = "RemoveClientsFromClassesResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.RemoveClientsFromClassesResponse")
    public RemoveClientsFromClassesResult removeClientsFromClasses(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        RemoveClientsFromClassesRequest request);

    /**
     * Adds clients to enrollments (signup).
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.AddClientsToEnrollmentsResult
     */
    @WebMethod(operationName = "AddClientsToEnrollments", action = "http://clients.mindbodyonline.com/api/0_5/AddClientsToEnrollments")
    @WebResult(name = "AddClientsToEnrollmentsResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "AddClientsToEnrollments", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.AddClientsToEnrollments")
    @ResponseWrapper(localName = "AddClientsToEnrollmentsResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.AddClientsToEnrollmentsResponse")
    public AddClientsToEnrollmentsResult addClientsToEnrollments(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        AddClientsToEnrollmentsRequest request);

    /**
     * Removes client from enrollment waitlist
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.RemoveFromWaitlistResult
     */
    @WebMethod(operationName = "RemoveFromWaitlist", action = "http://clients.mindbodyonline.com/api/0_5/RemoveFromWaitlist")
    @WebResult(name = "RemoveFromWaitlistResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "RemoveFromWaitlist", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.RemoveFromWaitlist")
    @ResponseWrapper(localName = "RemoveFromWaitlistResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.RemoveFromWaitlistResponse")
    public RemoveFromWaitlistResult removeFromWaitlist(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        RemoveFromWaitlistRequest request);

    /**
     * Gets a list of semesters.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.GetSemestersResult
     */
    @WebMethod(operationName = "GetSemesters", action = "http://clients.mindbodyonline.com/api/0_5/GetSemesters")
    @WebResult(name = "GetSemestersResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "GetSemesters", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetSemesters")
    @ResponseWrapper(localName = "GetSemestersResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetSemestersResponse")
    public GetSemestersResult getSemesters(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        GetSemestersRequest request);

    /**
     * Gets a list of courses.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.GetCoursesResult
     */
    @WebMethod(operationName = "GetCourses", action = "http://clients.mindbodyonline.com/api/0_5/GetCourses")
    @WebResult(name = "GetCoursesResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "GetCourses", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetCourses")
    @ResponseWrapper(localName = "GetCoursesResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetCoursesResponse")
    public GetCoursesResult getCourses(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        GetCoursesRequest request);

    /**
     * Get waitlist entries.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.GetWaitlistEntriesResult
     */
    @WebMethod(operationName = "GetWaitlistEntries", action = "http://clients.mindbodyonline.com/api/0_5/GetWaitlistEntries")
    @WebResult(name = "GetWaitlistEntriesResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "GetWaitlistEntries", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetWaitlistEntries")
    @ResponseWrapper(localName = "GetWaitlistEntriesResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.GetWaitlistEntriesResponse")
    public GetWaitlistEntriesResult getWaitlistEntries(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        GetWaitlistEntriesRequest request);

    /**
     * Substitutes the teacher for a class.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.SubstituteClassTeacherResult
     */
    @WebMethod(operationName = "SubtituteClassTeacher", action = "http://clients.mindbodyonline.com/api/0_5/SubtituteClassTeacher")
    @WebResult(name = "SubtituteClassTeacherResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "SubtituteClassTeacher", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.SubtituteClassTeacher")
    @ResponseWrapper(localName = "SubtituteClassTeacherResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.SubtituteClassTeacherResponse")
    public SubstituteClassTeacherResult subtituteClassTeacher(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        SubstituteClassTeacherRequest request);

    /**
     * Cancels a single class instance.
     * 
     * @param request
     * @return
     *     returns com.mindbodyonline.clients.api._0_5Class.CancelSingleClassResult
     */
    @WebMethod(operationName = "CancelSingleClass", action = "http://clients.mindbodyonline.com/api/0_5/CancelSingleClass")
    @WebResult(name = "CancelSingleClassResult", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
    @RequestWrapper(localName = "CancelSingleClass", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.CancelSingleClass")
    @ResponseWrapper(localName = "CancelSingleClassResponse", targetNamespace = "http://clients.mindbodyonline.com/api/0_5", className = "com.mindbodyonline.clients.api._0_5Class.CancelSingleClassResponse")
    public CancelSingleClassResult cancelSingleClass(
        @WebParam(name = "Request", targetNamespace = "http://clients.mindbodyonline.com/api/0_5")
        CancelSingleClassRequest request);

}
