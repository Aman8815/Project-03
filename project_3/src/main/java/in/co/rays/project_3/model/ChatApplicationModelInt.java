package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ChatApplicationDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface ChatApplicationModelInt {
	public long add(ChatApplicationDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(ChatApplicationDTO dto)throws ApplicationException;
	public void update(ChatApplicationDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(ChatApplicationDTO dto)throws ApplicationException;
	public List search(ChatApplicationDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public ChatApplicationDTO findByPK(long pk)throws ApplicationException;
	public ChatApplicationDTO findByName(String name)throws ApplicationException;

}
