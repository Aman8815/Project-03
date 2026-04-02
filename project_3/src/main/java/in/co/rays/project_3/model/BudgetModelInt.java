package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.BudgetDTO;
import in.co.rays.project_3.dto.CarRentalDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface BudgetModelInt {
	
	public long add(BudgetDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(BudgetDTO dto)throws ApplicationException;
	public void update(BudgetDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(BudgetDTO dto)throws ApplicationException;
	public List search(BudgetDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public BudgetDTO findByPK(long pk)throws ApplicationException;
	public BudgetDTO findByName(String name)throws ApplicationException;

}
