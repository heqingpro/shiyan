package com.cn.sys.user.service.impl;
import java.util.List;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
  










import com.cn.sys.user.dao.StudentDao;  
import com.cn.sys.user.pojo.Student;  
import com.cn.sys.user.service.StudentService;  
import com.cn.sys.user.pojo.PagingVO;

  
@Service("studentService") 
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDao studentDao;
	@Override
	public Student selectByName(String name){
		// TODO Auto-generated method stub  
		return this.studentDao.selectByPrimaryKey(name);
	}
	@Override
	public Student selectByNumber(String number){
		return this.studentDao.selectByNumber(number);
	}
	@Override
	public int delectByName(String name){
		return this.studentDao.deleteByPrimaryKey(name);
	}
	@Override
	public void regist(Student student){
		this.studentDao.insert(student);
	}
	@Override
	public boolean login(Student student){
		Student studenti=this.studentDao.selectByNumber(student.getNumber());
		if(studenti.getPassword().equals(student.getPassword()))
		return true;
		else return false;
	}
	@Override
    public List<Student> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<Student> list = studentDao.findByPaging(pagingVO);

        return list;
    }
	@Override
    //返回学生总数
    public int getCountStudent() throws Exception {

        return studentDao.countStudent();
    }
    //
	@Override
    //根据id获取学生信息
    public Student selectById(Integer id) throws Exception{
    	return this.studentDao.selectById(id);
    }
	@Override
    public void updataById(Integer id, Student student) throws Exception {
        studentDao.updateByPrimaryKey(student);
    }
	@Override
    public void removeById(Integer id) throws Exception{
    	this.studentDao.deleteById(id);
    }

    @Override
    public int save(Student student){
	    return studentDao.addStudent(student);
    }

}
