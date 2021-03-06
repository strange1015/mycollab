/**
 * This file is part of mycollab-services.
 *
 * mycollab-services is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-services is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-services.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.module.user.dao;

import com.esofthead.mycollab.core.persistence.ICrudGenericDAO;
import com.esofthead.mycollab.module.user.domain.RolePermission;
import com.esofthead.mycollab.module.user.domain.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings({ "ucd", "rawtypes" })
public interface RolePermissionMapper extends ICrudGenericDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int countByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int deleteByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int insert(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int insertSelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    List<RolePermission> selectByExampleWithBLOBs(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    List<RolePermission> selectByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    RolePermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int updateByExampleWithBLOBs(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int updateByPrimaryKeySelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int updateByPrimaryKeyWithBLOBs(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    int updateByPrimaryKey(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    Integer insertAndReturnKey(RolePermission value);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    void removeKeysWithSession(List primaryKeys);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_role_permission
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    void massUpdateWithSession(@Param("record") RolePermission record, @Param("primaryKeys") List primaryKeys);
}