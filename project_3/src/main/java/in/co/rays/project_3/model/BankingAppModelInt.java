package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.BankingAppDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface BankingAppModelInt {
	
	public long add(BankingAppDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(BankingAppDTO dto)throws ApplicationException;
	public void update(BankingAppDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(BankingAppDTO dto)throws ApplicationException;
	public List search(BankingAppDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public BankingAppDTO findByPK(long pk)throws ApplicationException;
	public BankingAppDTO findByName(String name)throws ApplicationException;

}
