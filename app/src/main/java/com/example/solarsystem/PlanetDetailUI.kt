package com.example.solarsystem

import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk21.coroutines.onClick
import org.jetbrains.anko.sdk21.coroutines.onLongClick

/**
 * Created by hend on 6/15/18.
 */

class PlanetDetailUI : AnkoComponent<PlanetDetailFragment> {

    //lateinit means they won't be available at the time of component creation
    lateinit var planetDescription: TextView
    lateinit var planetComposition: TextView
    lateinit var planetMoons: TextView
    lateinit var planetOrbit: TextView

    override fun createView(ui: AnkoContext<PlanetDetailFragment>): View {
        return with(ui) {
            //View are wrap_content by default
            val container = verticalLayout {
                lparams(matchParent)
                planetDescription = textView {
                    setLineSpacing(8f, 1f)
                    onClick { toast("Hey world from Anko!") }
                }.lparams {
                    topMargin = dip(16)
                }
                planetComposition = textView {
                    setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_landscape, 0, 0, 0)
                    onLongClick { owner.goToSpaceWebsite() }
                }
                planetMoons = textView {
                    setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_brightness, 0, 0, 0)
                }
                planetOrbit = textView {
                    setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_loop, 0, 0, 0)
                }
            }

            container.applyRecursively { view ->
                when(view) {
                    is TextView -> {
                        with(view){
                            padding = dip(16)
                            compoundDrawablePadding = dip(16)
                            setTextIsSelectable(true)
                            layoutParams.width = matchParent
                            textAppearance = R.style.TextAppearance_AppCompat_Medium
                        }
                    }
                }
            }

        }
    }

}