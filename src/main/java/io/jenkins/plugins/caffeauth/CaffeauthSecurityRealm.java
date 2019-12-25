
package io.jenkins.plugins.caffeauth;

import java.util.HashSet;
import java.util.Set;

import org.acegisecurity.AuthenticationException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.kohsuke.stapler.DataBoundConstructor;
import org.springframework.dao.DataAccessException;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.security.AbstractPasswordBasedSecurityRealm;
import hudson.security.GroupDetails;
import hudson.security.SecurityRealm;

public class CaffeauthSecurityRealm extends AbstractPasswordBasedSecurityRealm {

	public final String apiUrl, securityToken;

	@Extension
	public static final class DescriptorImpl extends Descriptor<SecurityRealm> {
		public String getDisplayName() {
			return "Authenticate via Caffe Auth";
		}
	}

	@DataBoundConstructor
	public CaffeauthSecurityRealm(String apiUrl, String securityToken) {
		this.apiUrl = apiUrl;
		this.securityToken = securityToken;
	}

	@Override
	protected UserDetails authenticate(String arg0, String arg1) throws AuthenticationException {
		// TODO Auto-generated method stub
		return getUserDetails();
	}

	private UserDetails getUserDetails() {

		return new UserDetails() {

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return "admin";
			}

			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return "admin";
			}

			@Override
			public GrantedAuthority[] getAuthorities() {
				Set<GrantedAuthority> groups = new HashSet<GrantedAuthority>();
				groups.add(SecurityRealm.AUTHENTICATED_AUTHORITY);

				return groups.toArray(new GrantedAuthority[groups.size()]);
			}
		};
	}

	@Override
	public GroupDetails loadGroupByGroupname(String arg0) throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return new GroupDetails() {

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "admin";
			}
		};
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return getUserDetails();
	}

}