package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.MeetingRoomDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface MeetingRoomModelInt {
	public long add(MeetingRoomDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(MeetingRoomDTO dto)throws ApplicationException;
	public void update(MeetingRoomDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(MeetingRoomDTO dto)throws ApplicationException;
	public List search(MeetingRoomDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public MeetingRoomDTO findByPK(long pk)throws ApplicationException;
	public MeetingRoomDTO findByName(String name)throws ApplicationException;

}
