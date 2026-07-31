package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ScholarshipDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface ScholarshipModelInt {
	
	public long add(ScholarshipDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(ScholarshipDTO dto)throws ApplicationException;
	public void update(ScholarshipDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(ScholarshipDTO dto)throws ApplicationException;
	public List search(ScholarshipDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public ScholarshipDTO findByPK(long pk)throws ApplicationException;
	public ScholarshipDTO findByName(String name)throws ApplicationException;

}
