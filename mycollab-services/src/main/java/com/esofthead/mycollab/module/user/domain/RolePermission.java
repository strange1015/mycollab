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
/*Domain class of table s_role_permission*/
package com.esofthead.mycollab.module.user.domain;

import com.esofthead.mycollab.core.arguments.ValuedBean;

@SuppressWarnings("ucd")
@com.esofthead.mycollab.core.db.metadata.Table("s_role_permission")
public class RolePermission extends ValuedBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role_permission.id
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("id")
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role_permission.roleid
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("roleid")
    private Integer roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role_permission.roleVal
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    @org.hibernate.validator.constraints.Length(max=65535, message="Field value is too long")
    @com.esofthead.mycollab.core.db.metadata.Column("roleVal")
    private String roleval;

    private static final long serialVersionUID = 1;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role_permission.id
     *
     * @return the value of s_role_permission.id
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role_permission.id
     *
     * @param id the value for s_role_permission.id
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role_permission.roleid
     *
     * @return the value of s_role_permission.roleid
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role_permission.roleid
     *
     * @param roleid the value for s_role_permission.roleid
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_role_permission.roleVal
     *
     * @return the value of s_role_permission.roleVal
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    public String getRoleval() {
        return roleval;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role_permission.roleVal
     *
     * @param roleval the value for s_role_permission.roleVal
     *
     * @mbggenerated Tue Jun 23 23:25:33 ICT 2015
     */
    public void setRoleval(String roleval) {
        this.roleval = roleval;
    }

    public static enum Field {
        id,
        roleid,
        roleval;

        public boolean equalTo(Object value) {
            return name().equals(value);
        }
    }
}