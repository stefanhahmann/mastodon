package org.mastodon.revised.mamut;

import org.mastodon.graph.GraphIdBimap;
import org.mastodon.graph.ListenableReadOnlyGraph;
import org.mastodon.model.DefaultFocusModel;
import org.mastodon.model.DefaultHighlightModel;
import org.mastodon.model.DefaultSelectionModel;
import org.mastodon.model.FocusModel;
import org.mastodon.model.HighlightModel;
import org.mastodon.model.SelectionModel;
import org.mastodon.revised.bdv.SharedBigDataViewerData;
import org.mastodon.revised.model.mamut.BoundingSphereRadiusStatistics;
import org.mastodon.revised.model.mamut.Link;
import org.mastodon.revised.model.mamut.Model;
import org.mastodon.revised.model.mamut.Spot;

/**
 * Data class that stores the data model and the application model of the MaMuT
 * application.
 *
 * @author Jean-Yves Tinevez
 */
public class MamutAppModel
{
	private final Model model;

	private final SelectionModel< Spot, Link > selectionModel;

	private final HighlightModel< Spot, Link > highlightModel;

	private final BoundingSphereRadiusStatistics radiusStats;

	private final FocusModel< Spot, Link > focusModel;

	private final SharedBigDataViewerData sharedBdvData;

	private final int minTimepoint;

	private final int maxTimepoint;

	public MamutAppModel(
			final Model model,
			final SharedBigDataViewerData sharedBdvData )
	{
		this.model = model;
		final ListenableReadOnlyGraph< Spot, Link > graph = model.getGraph();
		final GraphIdBimap< Spot, Link > idmap = model.getGraphIdBimap();
		this.selectionModel = new DefaultSelectionModel<>( graph, idmap );
		this.highlightModel = new DefaultHighlightModel<>( idmap );
		this.radiusStats = new BoundingSphereRadiusStatistics( model );
		this.focusModel = new DefaultFocusModel<>( idmap );
		this.sharedBdvData = sharedBdvData;
		this.minTimepoint = 0;
		this.maxTimepoint = sharedBdvData.getNumTimepoints() - 1;
	}

	public Model getModel()
	{
		return model;
	}

	public SelectionModel< Spot, Link > getSelectionModel()
	{
		return selectionModel;
	}

	public HighlightModel< Spot, Link > getHighlightModel()
	{
		return highlightModel;
	}

	public BoundingSphereRadiusStatistics getRadiusStats()
	{
		return radiusStats;
	}

	public FocusModel< Spot, Link > getFocusModel()
	{
		return focusModel;
	}

	public SharedBigDataViewerData getSharedBdvData()
	{
		return sharedBdvData;
	}

	public int getMinTimepoint()
	{
		return minTimepoint;
	}

	public int getMaxTimepoint()
	{
		return maxTimepoint;
	}
}
