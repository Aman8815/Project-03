package in.co.rays.project_3.model;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import in.co.rays.project_3.dto.OnlineCourseDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

/**
 * ModelFactory decides which model implementation run
 * 
 * @author Aman Yashona
 *
 */
public final class ModelFactory {

	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.system");
	private static final String DATABASE = rb.getString("DATABASE");
	private static ModelFactory mFactory = null;
	private static HashMap modelCache = new HashMap();

	private ModelFactory() {

	}

	public static ModelFactory getInstance() {
		if (mFactory == null) {
			mFactory = new ModelFactory();
		}
		return mFactory;
	}

	public StaffMemberModelInt getStaffMemberModel() {
		StaffMemberModelInt staffMemberModel = (StaffMemberModelInt) modelCache.get("staffMemberModel");
		if (staffMemberModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				staffMemberModel = new StaffMemberHibImpl();
			}
			if ("JDBC".equals(DATABASE)) {
				staffMemberModel = new StaffMemberJDBCImpl();
			}
			modelCache.put("staffMemberModel", staffMemberModel);
		}

		return staffMemberModel;
	}

	public ProductModelInt getProductModel() {
		ProductModelInt productModel = (ProductModelInt) modelCache.get("productModel");
		if (productModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				productModel = new ProductModelHibImp();
			}
			modelCache.put("productModel", productModel);
		}
		return productModel;
	}

	public MarksheetModelInt getMarksheetModel() {
		MarksheetModelInt marksheetModel = (MarksheetModelInt) modelCache.get("marksheetModel");
		if (marksheetModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				marksheetModel = new MarksheetModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				marksheetModel = new MarksheetModelJDBCImpl();
			}
			modelCache.put("marksheetModel", marksheetModel);
		}
		return marksheetModel;
	}

	public CollegeModelInt getCollegeModel() {
		CollegeModelInt collegeModel = (CollegeModelInt) modelCache.get("collegeModel");
		if (collegeModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				collegeModel = new CollegeModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				collegeModel = new CollegeModelJDBCImpl();
			}
			modelCache.put("collegeModel", collegeModel);
		}
		return collegeModel;
	}

	public RoleModelInt getRoleModel() {
		RoleModelInt roleModel = (RoleModelInt) modelCache.get("roleModel");
		if (roleModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				roleModel = new RoleModelHibImp();

			}
			if ("JDBC".equals(DATABASE)) {
				roleModel = new RoleModelJDBCImpl();
			}
			modelCache.put("roleModel", roleModel);
		}
		return roleModel;
	}

	public UserModelInt getUserModel() {

		UserModelInt userModel = (UserModelInt) modelCache.get("userModel");
		if (userModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				userModel = new UserModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				userModel = new UserModelJDBCImpl();
			}
			modelCache.put("userModel", userModel);
		}

		return userModel;
	}

	public StudentModelInt getStudentModel() {
		StudentModelInt studentModel = (StudentModelInt) modelCache.get("studentModel");
		if (studentModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				studentModel = new StudentModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				studentModel = new StudentModelJDBCImpl();
			}
			modelCache.put("studentModel", studentModel);
		}

		return studentModel;
	}

	public CourseModelInt getCourseModel() {
		CourseModelInt courseModel = (CourseModelInt) modelCache.get("courseModel");
		if (courseModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				courseModel = new CourseModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				courseModel = new CourseModelJDBCImpl();
			}
			modelCache.put("courseModel", courseModel);
		}

		return courseModel;
	}

	public TimetableModelInt getTimetableModel() {

		TimetableModelInt timetableModel = (TimetableModelInt) modelCache.get("timetableModel");

		if (timetableModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				timetableModel = new TimetableModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				timetableModel = new TimetableModelJDBCImpl();
			}
			modelCache.put("timetableModel", timetableModel);
		}

		return timetableModel;
	}

	public SubjectModelInt getSubjectModel() {
		SubjectModelInt subjectModel = (SubjectModelInt) modelCache.get("subjectModel");
		if (subjectModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				subjectModel = new SubjectModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				subjectModel = new SubjectModelJDBCImpl();
			}
			modelCache.put("subjectModel", subjectModel);
		}

		return subjectModel;
	}

	public FacultyModelInt getFacultyModel() {
		FacultyModelInt facultyModel = (FacultyModelInt) modelCache.get("facultyModel");
		if (facultyModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				facultyModel = new FacultyModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				facultyModel = new FacultyModelJDBCImpl();
			}
			modelCache.put("facultyModel", facultyModel);
		}

		return facultyModel;
	}
	
	public OnlineCourseModelInt getOnlineCourseModel() {
		OnlineCourseModelInt OnlineCourseModel = (OnlineCourseModelInt) modelCache.get("OnlineCourseModel");
		if (OnlineCourseModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				OnlineCourseModel = new OnlineCourseModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				OnlineCourseModel = new OnlineCourseModelHibImp();
			}
			modelCache.put("OnlineCourseModel", OnlineCourseModel);
		}

		return OnlineCourseModel;
	}
	
	public MeetingRoomModelInt getMeetingRoomModel() {
		MeetingRoomModelInt MeetingRoomModel = (MeetingRoomModelInt) modelCache.get("MeetingRoomModel");
		if (MeetingRoomModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				MeetingRoomModel = new MeetingRoomModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				MeetingRoomModel = new MeetingRoomModelHibImp();
			}
			modelCache.put("MeetingRoomModel", MeetingRoomModel);
		}

		return MeetingRoomModel;
	}
	
	public ComplaintModelInt getComplaintModel() {
		ComplaintModelInt ComplaintModel = (ComplaintModelInt) modelCache.get("ComplaintModel");
		if (ComplaintModel == null) {
			if ("Hibernate".equals(DATABASE)) {
				ComplaintModel = new ComplaintModelHibImp();
			}
			if ("JDBC".equals(DATABASE)) {
				ComplaintModel = new ComplaintModelHibImp();
			}
			modelCache.put("ComplaintModel", ComplaintModel);
		}

		return ComplaintModel;
	}
  
	public RefundModelInt getRefundModel() {
		RefundModelInt RefundModel = (RefundModelInt) modelCache.get("RefundModel");
		if(RefundModel == null) {
			if("Hibernate".equals(DATABASE)) {
				RefundModel = new RefundModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				RefundModel = new RefundModelHibImp();
			}
			
			modelCache.put("RefundModel", RefundModel);
		}
		return RefundModel;
	}
	
	public ScheduleModelInt getScheduleModel() {
		ScheduleModelInt ScheduleModel = (ScheduleModelInt) modelCache.get("ScheduleModel");
		if(ScheduleModel == null) {
			if("Hibernate".equals(DATABASE)) {
				ScheduleModel = new ScheduleModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				ScheduleModel = new ScheduleModelHibImp();
			}
			
			modelCache.put("ScheduleModel", ScheduleModel);
		}
		return ScheduleModel;
	}
	
	public CarRentalModelInt getCarRentalModel() {
		CarRentalModelInt CarRentalModel = (CarRentalModelInt) modelCache.get("CarRentalModel");
		if(CarRentalModel == null) {
			if("Hibernate".equals(DATABASE)) {
				CarRentalModel = new CarRentalModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				CarRentalModel = new CarRentalModelHibImp();
			}
			
			modelCache.put("CarRentalModel", CarRentalModel);
		}
		return CarRentalModel;
	}
	
	public BudgetModelInt getBudgetModel() {
		BudgetModelInt BudgetModel = (BudgetModelInt) modelCache.get("BudgetModel");
		if(BudgetModel == null) {
			if("Hibernate".equals(DATABASE)) {
				BudgetModel = new BudgetModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				BudgetModel = new BudgetModelHibImp();
			}
			
			modelCache.put("BudgetModel", BudgetModel);
		}
		return BudgetModel;
	}
	
	public LoanModelInt getLoanModel() {
		LoanModelInt LoanModel = (LoanModelInt) modelCache.get("LoanModel");
		if(LoanModel == null) {
			if("Hibernate".equals(DATABASE)) {
				LoanModel = new LoanModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				LoanModel = new LoanModelHibImp();
			}
			
			modelCache.put("BudgetModel", LoanModel);
		}
		return LoanModel;
	}
	
	public PressModelInt getPressModel() {
		PressModelInt PressModel = (PressModelInt) modelCache.get("PressModel");
		if(PressModel == null) {
			if("Hibernate".equals(DATABASE)) {
				PressModel = new PressModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				PressModel = new PressModelHibImp();
			}
			
			modelCache.put("PressModel", PressModel);
		}
		return PressModel;
	}
	
	public ReturnModelInt getReturnModel() {
		ReturnModelInt ReturnModel = (ReturnModelInt) modelCache.get("ReturnModel");
		if(ReturnModel == null) {
			if("Hibernate".equals(DATABASE)) {
				ReturnModel = new ReturnModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				ReturnModel = new ReturnModelHibImp();
			}
			
			modelCache.put("ReturnModel", ReturnModel);
		}
		return ReturnModel;
	}
	
	public DecorationModelInt getDecorationModel() {
		DecorationModelInt DecorationModel = (DecorationModelInt) modelCache.get("DecorationModel");
		if(DecorationModel == null) {
			if("Hibernate".equals(DATABASE)) {
				DecorationModel = new DecorationModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				DecorationModel = new DecorationModelHibImp();
			}
			
			modelCache.put("DecorationModel", DecorationModel);
		}
		return DecorationModel;
	}
	
	public NotificationModelInt getNotificationModel() {
		NotificationModelInt NotificationModel = (NotificationModelInt) modelCache.get("NotificationModel");
		if(NotificationModel == null) {
			if("Hibernate".equals(DATABASE)) {
				NotificationModel = new NotificationModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				NotificationModel = new NotificationModelHibImp();
			}
			
			modelCache.put("NotificationModel", NotificationModel);
		}
		return NotificationModel;
	}
	
	public SmartParkingModelInt getSmartParkingModel() {
		SmartParkingModelInt SmartParkingModel = (SmartParkingModelInt) modelCache.get("SmartParkingModel");
		if(SmartParkingModel == null) {
			if("Hibernate".equals(DATABASE)) {
				SmartParkingModel = new SmartParkingModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				SmartParkingModel = new SmartParkingModelHibImp();
			}
			
			modelCache.put("SmartParkingModel", SmartParkingModel);
		}
		return SmartParkingModel;
	}
	
	public PodcastModelInt getPodcastModel() {
		PodcastModelInt PodcastModel = (PodcastModelInt) modelCache.get("PodcastModel");
		if(PodcastModel == null) {
			if("Hibernate".equals(DATABASE)) {
				PodcastModel = new PodcastModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				PodcastModel = new PodcastModelHibImp();
			}
			
			modelCache.put("PodcastModel", PodcastModel);
		}
		return PodcastModel;
	}
	
	public NFTAssetModelInt getNFTAssetModel() {
		NFTAssetModelInt NFTAssetModel = (NFTAssetModelInt) modelCache.get("NFTAssetModel");
		if(NFTAssetModel == null) {
			if("Hibernate".equals(DATABASE)) {
				NFTAssetModel = new NFTAssetModelHibImp();
			}
			if("JDBC".equals(DATABASE)){
				NFTAssetModel = new NFTAssetModelHibImp();
			}
			
			modelCache.put("NFTAssetModel", NFTAssetModel);
		}
		return NFTAssetModel;
	}
	
	
}
