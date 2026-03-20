package in.co.rays.project_3.model;

import java.util.List;


import in.co.rays.project_3.dto.OnlineCourseDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface OnlineCourseModelInt {
	
	public long add(OnlineCourseDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(OnlineCourseDTO dto)throws ApplicationException;
	public void update(OnlineCourseDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(OnlineCourseDTO dto)throws ApplicationException;
	public List search(OnlineCourseDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public OnlineCourseDTO findByPK(long pk)throws ApplicationException;
	public OnlineCourseDTO findByName(String name)throws ApplicationException;

}
