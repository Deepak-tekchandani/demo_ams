package com.demo.am.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Where(clause = "status=true")
@Table(name = "role")
public class RoleModel extends Model{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "role_id")
	private Long roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "description")
	private String description;

	// ############################### All associated collections (many-to-many) go here #################################################
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "role_module", joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "module_id", nullable = false, updatable = false) })
//	private Set<ModuleModel> modules = new HashSet<ModuleModel>(0);
//
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "permission_id", nullable = false, updatable = false))
//	private Set<PermissionModel> permissions = new HashSet<PermissionModel>(0);
	
}
