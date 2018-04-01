package com.cn.sys.user.service.impl;

import com.cn.sys.user.dao.TeacherDao;
import com.cn.sys.user.pojo.PagingVO;
import com.cn.sys.user.pojo.Teacher;
import com.cn.sys.user.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;
    @Override
    public Teacher selectByName(String name){
        // TODO Auto-generated method stub
        return this.teacherDao.selectByPrimaryKey(name);
    }

    @Override
    public void regist(Teacher teacher){
        this.teacherDao.insert(teacher);
    }
    @Override
    public boolean login(Teacher teacher){
        Teacher teacheri=this.teacherDao.selectByNumber(teacher.getNumber());
        if(teacheri.getPassword().equals(teacher.getPassword()))
            return true;
        else return false;
    }
    @Override
    public List<Teacher> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<Teacher> list = teacherDao.findByPaging(pagingVO);

        return list;
    }
    @Override
    //返回教师总数
    public int getCountTeacher() throws Exception {

        return teacherDao.countTeacher();
    }
    //
    @Override
    //根据id获取教师信息
    public Teacher selectById(Integer id) throws Exception{
        return this.teacherDao.selectById(id);
    }
    @Override
    public void updataById(Integer id, Teacher teacher) throws Exception {
        teacherDao.updateByPrimaryKey(teacher);
    }
    @Override
    public void removeById(Integer id) throws Exception{
        this.teacherDao.deleteById(id);
    }

    @Override
    public int save(Teacher teacher){
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public List<Teacher> findByName(String name){
        return teacherDao.findByName(name);
    }

}
