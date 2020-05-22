package per.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import per.sc.pojo.Role;
import per.sc.pojo.dto.RoleDto;
import per.sc.service.RoleService;

/**
 * 角色相关接口
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;


//	/**
//	 * 保存角色
//	 * @param roleDto
//	 */
//	@PostMapping
//	@PreAuthorize("hasAuthority('sys:role:add')")
//	public void saveRole(@RequestBody RoleDto roleDto) {
//		roleService.insert(roleDto);
//	}

//	/**
//	 * 角色列表
//	 * @param request
//	 * @return
//	 */
//	@GetMapping
//	@PreAuthorize("hasAuthority('sys:role:query')")
//	public PageTableResponse listRoles(PageTableRequest request) {
//		return new PageTableHandler(new CountHandler() {
//
//			@Override
//			public int count(PageTableRequest request) {
//				return roleDao.count(request.getParams());
//			}
//		}, new ListHandler() {
//
//			@Override
//			public List<Role> list(PageTableRequest request) {
//				List<Role> list = roleDao.list(request.getParams(), request.getOffset(), request.getLimit());
//				return list;
//			}
//		}).handle(request);
//	}

	/**
	 * 根据id获取角色
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('sys:role:query')")
	public Role get(@PathVariable Long id) {
		return roleService.selectByPrimaryKey(id);
	}

//	/**
//	 * 所有角色
//	 * @return
//	 */
//	@GetMapping("/all")
//	@PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
//	public List<Role> roles() {
//		return roleDao.list(Maps.newHashMap(), null, null);
//	}
//
//	/**
//	 * 根据用户id获取拥有的角色
//	 * @param userId
//	 * @return
//	 */
//	@GetMapping(params = "userId")
//	@PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
//	public List<Role> roles(Long userId) {
//		return roleDao.listByUserId(userId);
//	}
//
//	/**
//	 * 删除角色
//	 */
//	@DeleteMapping("/{id}")
//	@PreAuthorize("hasAuthority('sys:role:del')")
//	public void delete(@PathVariable Long id) {
//		roleService.deleteRole(id);
//	}
}
