
/* eXist Native XML Database
 * Copyright (C) 2000-03,  Wolfgang M. Meier (wolfgang@exist-db.org)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 * $Id$
 */
 
package org.exist.xpath;

import org.exist.dom.DocumentSet;
import org.exist.xpath.value.Item;
import org.exist.xpath.value.Sequence;

public abstract class AbstractExpression implements Expression {

	protected StaticContext context;
	
	public AbstractExpression(StaticContext context) {
		this.context = context;
	}
	
	public Sequence eval(DocumentSet docs, Sequence contextSequence) 
		throws XPathException {
		return eval(docs, contextSequence, null); 
	}
	
	public abstract Sequence eval(DocumentSet docs, Sequence contextSequence, Item contextItem) throws XPathException;
		
	public abstract DocumentSet preselect(DocumentSet in_docs) throws XPathException;
	
	public abstract String pprint();
	
	public abstract int returnsType();
	
	public int getCardinality() {
		return Cardinality.EXACTLY_ONE;	// default cardinality
	}
	
	public void setInPredicate(boolean inPredicate) {
		// has no effect by default
	}
	
	/* (non-Javadoc)
	 * @see org.exist.xpath.Expression#getDependencies()
	 */
	public int getDependencies() {
		return Dependency.DEFAULT_DEPENDENCIES;
	}
}
