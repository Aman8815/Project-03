package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ExamDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface ExamModelInt {
	public long add(ExamDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(ExamDTO dto)throws ApplicationException;
	public void update(ExamDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(ExamDTO dto)throws ApplicationException;
	public List search(ExamDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public ExamDTO findByPK(long pk)throws ApplicationException;
	public ExamDTO findByName(String name)throws ApplicationException;

}
