/*
 *    Copyright (C) 2008-2010 Igor Kriznar
 *    
 *    This file is part of GTD-Free.
 *    
 *    GTD-Free is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *    
 *    GTD-Free is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *    
 *    You should have received a copy of the GNU General Public License
 *    along with GTD-Free.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.gtdfree.model;

/**
 * @author ikesan
 *
 */
public class ANDActionFilter implements ActionFilter {
	
	private final ActionFilter[] filters;
	
	public ANDActionFilter(ActionFilter... f) {
		filters=f;
	}

	/* (non-Javadoc)
	 * @see org.gtdfree.model.ActionFilter#isAcceptable(org.gtdfree.model.Folder, org.gtdfree.model.Action)
	 */
	@Override
	public boolean isAcceptable(Folder f, Action a) {
		if (filters!=null) {
			for (ActionFilter ff : filters) {
				if (ff!=null && !ff.isAcceptable(f, a)) {
					return false;
				}
			}
		}
		return true;
	}

}
