package in.co.rays.project_3.controller;

/**
 * ORS View Provide Loose Coupling
 * 
 * @author Aman Yashona
 *
 */
public interface ORSView {
	public String APP_CONTEXT = "/project_3";

	public String PAGE_FOLDER = "/jsp";

	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";

	public String ERROR_VIEW = PAGE_FOLDER + "/ErrorView404.jsp";

	public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";
	public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
	public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String COLLEGE_VIEW = PAGE_FOLDER + "/CollegeView.jsp";
	public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";
	public String STUDENT_VIEW = PAGE_FOLDER + "/StudentView.jsp";
	public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentListView.jsp";
	public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
	public String ROLE_LIST_VIEW = PAGE_FOLDER + "/RoleListView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";
	public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER + "/MarksheetMeritListView.jsp";

	public String FACULTY_VIEW = PAGE_FOLDER + "/FacultyView.jsp";
	public String FACULTY_LIST_VIEW = PAGE_FOLDER + "/FacultyListView.jsp";
	public String COURSE_VIEW = PAGE_FOLDER + "/CourseView.jsp";
	public String COURSE_LIST_VIEW = PAGE_FOLDER + "/CourseListView.jsp";
	public String TIMETABLE_VIEW = PAGE_FOLDER + "/TimeTableView.jsp";
	public String TIMETABLE_LIST_VIEW = PAGE_FOLDER + "/TimeTableListView.jsp";
	public String SUBJECT_VIEW = PAGE_FOLDER + "/SubjectView.jsp";
	public String SUBJECT_LIST_VIEW = PAGE_FOLDER + "/SubjectListView.jsp";
	public String PRODUCT_VIEW = PAGE_FOLDER + "/ProductView.jsp";
	public String PRODUCT_LIST_VIEW = PAGE_FOLDER + "/ProductListView.jsp";
	public String STAFF_MEMBER_VIEW = PAGE_FOLDER + "/StaffMemberView.jsp";
	public String STAFF_MEMBER_LIST_VIEW = PAGE_FOLDER + "/StaffMemberListView.jsp";
	
	public String ONLINE_COURSE_VIEW = PAGE_FOLDER + "/OnlineCourseView.jsp";
	public String ONLINE_COURSE_LIST_VIEW = PAGE_FOLDER + "/OnlineCourseListView.jsp";
	
	public String MEETING_ROOM_VIEW = PAGE_FOLDER + "/MeetingRoomView.jsp";
	public String MEETING_ROOM_LIST_VIEW = PAGE_FOLDER +"/MeetingRoomListView.jsp";
	
	public String COMPLAINT_VIEW = PAGE_FOLDER + "/ComplaintView.jsp";
	public String COMPLAINT_LIST_VIEW = PAGE_FOLDER +"/ComplaintListView.jsp";
	
	public String REFUND_VIEW = PAGE_FOLDER +"/RefundView.jsp";
	public String REFUND_LIST_VIEW = PAGE_FOLDER +"/RefundListView.jsp";
	
	public String SCHEDULE_VIEW = PAGE_FOLDER+"/ScheduleView.jsp";
	public String SCHEDULE_LIST_VIEW = PAGE_FOLDER +"/ScheduleListView.jsp";
	
	public String CAR_RENTAL_VIEW = PAGE_FOLDER+"/CarRentalView.jsp";
	public String CAR_RENTAL_LIST_VIEW = PAGE_FOLDER +"/CarRentalListView.jsp";
	
	public String BUDGET_VIEW = PAGE_FOLDER+"/BudgetView.jsp";
	public String BUDGET_LIST_VIEW = PAGE_FOLDER+"/BudgetListView.jsp";
	
	public String LOAN_VIEW = PAGE_FOLDER+"/LoanView.jsp";
	public String LOAN_LIST_VIEW = PAGE_FOLDER+"/LoanListView.jsp";
	
	public String PRESS_VIEW = PAGE_FOLDER+"/PressView.jsp";
	public String PRESS_LIST_VIEW = PAGE_FOLDER+"/PressListView.jsp";
	
	public String RETURN_VIEW = PAGE_FOLDER+"/ReturnView.jsp";
	public String RETURN_LIST_VIEW = PAGE_FOLDER+"/ReturnListView.jsp";
	
	public String DECORATION_VIEW = PAGE_FOLDER+"/DecorationView.jsp";
	public String DECORATION_LIST_VIEW = PAGE_FOLDER+"/DecorationListView.jsp";
	
	public String NOTIFICATION_VIEW = PAGE_FOLDER+"/NotificationView.jsp";
	public String NOTIFICATION_LIST_VIEW = PAGE_FOLDER+"/NotificationListView.jsp";
	
	public String SMARTPARKING_VIEW = PAGE_FOLDER+"/SmartParkingView.jsp";
	public String SMARTPARKING_LIST_VIEW = PAGE_FOLDER+"/SmartParkingListView.jsp";
	
	public String PODCAST_VIEW = PAGE_FOLDER+"/PodcastView.jsp";
	public String PODCAST_LIST_VIEW = PAGE_FOLDER+"/PodcastListView.jsp";
	
	public String NFTASSET_VIEW = PAGE_FOLDER+"/NFTAssetView.jsp";
	public String NFTASSET_LIST_VIEW = PAGE_FOLDER+"/NFTAssetListView.jsp";
	
	public String ECOMMERCE_VIEW = PAGE_FOLDER+"/ECommerceView.jsp";
	public String ECOMMERCE_LIST_VIEW = PAGE_FOLDER+"/ECommerceListView.jsp";
	
	public String VOICEASSISTANT_VIEW = PAGE_FOLDER+"/VoiceAssistantView.jsp";
	public String VOICEASSISTANT_LIST_VIEW = PAGE_FOLDER+"/VoiceAssistantListView.jsp";
	
	public String CHATAPPLICATION_VIEW = PAGE_FOLDER+"/ChatApplicationView.jsp";
	public String CHATAPPLICATION_LIST_VIEW = PAGE_FOLDER+"/ChatApplicationListView.jsp";
	
	public String BANKINGAPP_VIEW = PAGE_FOLDER+"/BankingAppView.jsp";
	public String BANKINGAPP_LIST_VIEW = PAGE_FOLDER+"/BankingAppListView.jsp";
	
	public String PETROLPUMP_VIEW = PAGE_FOLDER+"/PetrolpPumpView.jsp";
	public String PETROLPUMP_LIST_VIEW = PAGE_FOLDER+"/PetrolPumpListView.jsp";
	
	public String INSURANCEAPP_VIEW = PAGE_FOLDER+"/InsuranceAppView.jsp";
	public String INSURANCEAPP_LIST_VIEW = PAGE_FOLDER+"/InsuranceAppListView.jsp";
	
	public String WATER_VIEW = PAGE_FOLDER+"/WaterView.jsp";
	public String WATER_LIST_VIEW = PAGE_FOLDER+"/WaterListView.jsp";
	
	public String SMART_VIEW = PAGE_FOLDER+"/SmartView.jsp";
	public String SMART_LIST_VIEW = PAGE_FOLDER+"/SmartListView.jsp";
	
	public String EXAM_VIEW = PAGE_FOLDER+"/ExamView.jsp";
	public String EXAM_LIST_VIEW = PAGE_FOLDER+"/ExamListView.jsp";
	
	public String SCHOLARSHIP_VIEW = PAGE_FOLDER+"/ScholarshipView.jsp";
	public String SCHOLARSHIP_LIST_VIEW = PAGE_FOLDER+"/ScholarshipListView.jsp";
	
	public String RESULT_VIEW = PAGE_FOLDER+"/ResultView.jsp";
	public String RESULT_LIST_VIEW = PAGE_FOLDER+"/ResultListView.jsp";
	
	public String FEE_VIEW = PAGE_FOLDER+"/FeeView.jsp";
	public String FEE_LIST_VIEW = PAGE_FOLDER+"/FeeListView.jsp";
	
	public String DEPARTMENT_VIEW = PAGE_FOLDER+"/DepartmentView.jsp";
	public String DEPARTMENT_LIST_VIEW = PAGE_FOLDER+"/DepartmentListView.jsp";
	
	public String VEHICLE_VIEW = PAGE_FOLDER+"/VehicleView.jsp";
	public String VEHICLE_LIST_VIEW =PAGE_FOLDER+"/VehicleListView.jsp";

	public String ERROR_CTL = APP_CONTEXT + "/ErrorCtl";

	public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
	public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	public String COLLEGE_CTL = APP_CONTEXT + "/ctl/CollegeCtl";
	public String COLLEGE_LIST_CTL = APP_CONTEXT + "/ctl/CollegeListCtl";
	public String STUDENT_CTL = APP_CONTEXT + "/ctl/StudentCtl";
	public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/StudentListCtl";
	public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
	public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";

	public String FACULTY_CTL = APP_CONTEXT + "/ctl/FacultyCtl";
	public String FACULTY_LIST_CTL = APP_CONTEXT + "/ctl/FacultyListCtl";
	public String COURSE_CTL = APP_CONTEXT + "/ctl/CourseCtl";
	public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/CourseListCtl";
	public String SUBJECT_CTL = APP_CONTEXT + "/ctl/SubjectCtl";
	public String SUBJECT_LIST_CTL = APP_CONTEXT + "/ctl/SubjectListCtl";
	public String TIMETABLE_CTL = APP_CONTEXT + "/ctl/TimeTableCtl";
	public String TIMETABLE_LIST_CTL = APP_CONTEXT + "/ctl/TimeTableListCtl";
	public String PRODUCT_CTL = APP_CONTEXT + "/ctl/ProductCtl";
	public String PRODUCT_LIST_CTL = APP_CONTEXT + "/ctl/ProductListCtl";
	public String STAFF_MEMBER_CTL = APP_CONTEXT + "/ctl/StaffMemberCtl";
	public String STAFF_MEMBER_LIST_CTL = APP_CONTEXT + "/ctl/StaffMemberListCtl";

	public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";
	
	public String ONLINE_COURSE_CTL = APP_CONTEXT + "/ctl/OnlineCourseCtl";
	public String ONLINE_COURSE_LIST_CTL = APP_CONTEXT + "/ctl/OnlineCourseListCtl";
	
	public String MEETING_ROOM_CTL = APP_CONTEXT + "/ctl/MeetingRoomCtl";
	public String MEETING_ROOM_LIST_CTL = APP_CONTEXT + "/ctl/MeetingRoomListCtl";
	
	public String COMPLAINT_CTL = APP_CONTEXT + "/ctl/ComplaintCtl";
	public String COMPLAINT_LIST_CTL = APP_CONTEXT + "/ctl/ComplaintListCtl";
	
	public String REFUND_CTL = APP_CONTEXT + "/ctl/RefundCtl";
	public String REFUND_LIST_CTL = APP_CONTEXT+ "/ctl/RefundListCtl";
	
	public String SCHEDULE_CTL = APP_CONTEXT+"/ctl/ScheduleCtl";
	public String SCHEDULE_LIST_CTL = APP_CONTEXT+"/ctl/ScheduleListCtl";
	
	public String CAR_RENTAL_CTL = APP_CONTEXT +"/ctl/CarRentalCtl";
	public String CAR_RENTAL_LIST_CTL = APP_CONTEXT +"/ctl/CarRentalListCtl";
	
	public String BUDGET_CTL = APP_CONTEXT+"/ctl/BudgetCtl";
	public String BUDGET_LIST_CTL = APP_CONTEXT+"/ctl/BudgetListCtl";
	
	public String LOAN_CTL = APP_CONTEXT+"/ctl/LoanCtl";
	public String LOAN_LIST_CTL = APP_CONTEXT+"/ctl/LoanListCtl";

	public String PRESS_CTL = APP_CONTEXT +"/ctl/PressCtl";
	public String PRESS_LIST_CTL = APP_CONTEXT+"/ctl/PressListCtl";
	
	public String RETURN_CTL = APP_CONTEXT+"/ctl/ReturnCtl";
	public String RETURN_LIST_CTL = APP_CONTEXT+"/ctl/ReturnListCtl";
	
	public String DECORATION_CTL = APP_CONTEXT+"/ctl/DecorationCtl";
	public String DECORATION_LIST_CTL = APP_CONTEXT+"/ctl/DecorationListCtl";
	
	public String NOTIFICATION_CTL = APP_CONTEXT+"/ctl/NotificationCtl";
	public String NOTIFICATION_LIST_CTL = APP_CONTEXT+"/ctl/NotificationListCtl";
	
	public String SMARTPARKING_CTL= APP_CONTEXT+"/ctl/SmartParkingCtl";
	public String SMARTPARKING_LIST_CTL = APP_CONTEXT+"/ctl/SmartParkingListCtl";
	
	public String PODCAST_CTL = APP_CONTEXT+"/ctl/PodcastCtl";
	public String PODCAST_LIST_CTL = APP_CONTEXT+"/ctl/PodcastListCtl";
	
	public String NFTASSET_CTL = APP_CONTEXT+"/ctl/NFTAssetCtl";
	public String NFTASSET_LIST_CTL = APP_CONTEXT+"/ctl/NFTAssetListCtl";
	
	public String ECOMMERCE_CTL = APP_CONTEXT+"/ctl/ECommerceCtl";
	public String ECOMMERCE_LIST_CTL = APP_CONTEXT+"/ctl/ECommerceListCtl";
	
	public String VOICEASSISTANT_CTL = APP_CONTEXT+"/ctl/VoiceAssistantCtl";
	public String VOICEASSISTANT_LIST_CTL = APP_CONTEXT+"/ctl/VoiceAssistantListCtl";
	
	public String CHATAPPLICATION_CTL = APP_CONTEXT+"/ctl/ChatApplicationCtl";
	public String CHATAPPLICATION_LIST_CTL = APP_CONTEXT+"/ctl/ChatApplicationListCtl";
	
	public String BANKINGAPP_CTL = APP_CONTEXT+"/ctl/BankingAppCtl";
	public String BANKINGAPP_LIST_CTL = APP_CONTEXT+"/ctl/BankingAppListCtl";
	
	public String PETROLPUMP_CTL = APP_CONTEXT+"/ctl/PetrolPumpCtl";
	public String PETROLPUMP_LIST_CTL = APP_CONTEXT+"/ctl/PetrolPumpListCtl";
	
	public String INSURANCEAPP_CTL = APP_CONTEXT+"/ctl/InsuranceAppCtl";
	public String INSURANCEAPP_LIST_CTL = APP_CONTEXT+"/ctl/InsuranceAppListCtl";
	
	public String WATER_CTL = APP_CONTEXT+"/ctl/WaterCtl";
	public String WATER_LIST_CTL = APP_CONTEXT+"/ctl/WaterListCtl";
	
	public String SMART_CTL = APP_CONTEXT+"/ctl/SmartCtl";
	public String SMART_LIST_CTL = APP_CONTEXT+"/ctl/SmartListCtl";
	
	public String EXAM_CTL = APP_CONTEXT+"/ctl/ExamCtl";
	public String EXAM_LIST_CTL = APP_CONTEXT+"/ctl/ExamListCtl";
	
	public String SCHOLARSHIP_CTL = APP_CONTEXT+"/ctl/ScholarshipCtl";
	public String SCHOLARSHIP_LIST_CTL = APP_CONTEXT+"/ctl/ScholarshipListCtl";
	
	public String RESULT_CTL = APP_CONTEXT+"/ctl/ResultCtl";
	public String RESULT_LIST_CTL = APP_CONTEXT+"/ctl/ResultListCtl";
	
	public String FEE_CTL = APP_CONTEXT+"/ctl/FeeCtl";
	public String FEE_LIST_CTL =APP_CONTEXT+"/ctl/FeeListCtl";
	
	public String DEPARTMENT_CTL = APP_CONTEXT+"/ctl/DepartmentCtl";
	public String DEPARTMENT_LIST_CTL = APP_CONTEXT+"/ctl/DepartmentListCtl";
	
	public String VEHICLE_CTL = APP_CONTEXT+"/ctl/VehicleCtl";
	public String VEHICLE_LIST_CTL = APP_CONTEXT+"/ctl/VehicleListCtl";
}
