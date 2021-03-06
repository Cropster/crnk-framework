package io.crnk.core.engine.query;

import io.crnk.core.engine.information.resource.ResourceInformation;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.queryspec.pagingspec.PagingSpec;
import io.crnk.legacy.queryParams.QueryParams;
import io.crnk.legacy.queryParams.params.IncludedFieldsParams;
import io.crnk.legacy.queryParams.params.IncludedRelationsParams;
import io.crnk.legacy.queryParams.params.TypedParams;

public interface QueryAdapter {

	TypedParams<IncludedRelationsParams> getIncludedRelations();

	TypedParams<IncludedFieldsParams> getIncludedFields();

	ResourceInformation getResourceInformation();

	QueryContext getQueryContext();

	/**
	 * @return maximum number of resources to return or null for unbounded
	 */
	@Deprecated
	Long getLimit();

	@Deprecated
	void setLimit(Long limit);

	/**
	 * @return maximum number of resources to skip in the response.
	 */
	@Deprecated
	long getOffset();

	@Deprecated
	void setOffset(long offset);

	/**
	 * @return duplicate of this instance
	 */
	QueryAdapter duplicate();

	/**
	 * The {@link QueryParams} instance for this query adapter if possible.
	 *
	 * @return may return null if the implementation does not support QueryParams
	 */
	@Deprecated
	QueryParams toQueryParams();

	/**
	 * The {@link QuerySpec} instance for this query adapter if possible.
	 *
	 * @return may return null if the implementation does not support QueryParams
	 */
	QuerySpec toQuerySpec();

	boolean getCompactMode();

	void setPagingSpec(PagingSpec pagingSpec);

	PagingSpec getPagingSpec();

	boolean isEmpty();
}
