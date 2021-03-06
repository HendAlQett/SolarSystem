package com.example.solarsystem

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.solarsystem.dummy.Planet
import com.example.solarsystem.dummy.PlanetsDataProvider
import com.example.solarsystem.dummy.composition
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.browse
import org.jetbrains.anko.support.v4.ctx

const val ARG_ITEM_ID = "item_id"

const val TERRESTRIAL = "Terrestrial"
const val GAS_GIANT = "Gas Giant"

class PlanetDetailFragment : Fragment() {

    private var planet: Planet? = null

    //Create something lazily means to only create it the first time it is accessed.
    private val ui by lazy { PlanetDetailUI() }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        if (arguments.containsKey(ARG_ITEM_ID)) {
            planet = PlanetsDataProvider.ITEM_MAP[arguments.getString(ARG_ITEM_ID)]
            planet?.let {
                val activity = this.activity
                val appBarLayout = activity.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
                appBarLayout.title = it.name

                val image = activity.findViewById<ImageView>(R.id.image)
                image.setImageResource(it.imageResourceId)
            }
        }

        return ui.createView(AnkoContext.create(ctx,this))
    }

    override fun onResume() {
        super.onResume()

        planet?.let {
            ui.planetDescription.text = it.description
            ui.planetComposition.text = it.composition
            ui.planetMoons.text = getString(R.string.num_known_moons, it.knownMoons)
            ui.planetOrbit.text = getString(R.string.orbital_period_years, it.orbitalPeriod)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        planet?.let {
            arguments.putString(ARG_ITEM_ID, it.id)
        }
    }

    fun goToSpaceWebsite() {
        browse("https://www.space.com")

    }

}
