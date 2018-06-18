package com.example.solarsystem

import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*

/**
 * Created by hend on 6/15/18.
 */

class PlanetDetailUI : AnkoComponent<PlanetDetailFragment> {
    override fun createView(ui: AnkoContext<PlanetDetailFragment>): View {
        return with(ui) {
            //View are wrap_content by default
            val container = verticalLayout {
                lparams(matchParent)
                textView {
                    setLineSpacing(8f, 1f)
                }.lparams {
                    topMargin = dip(16)
                }
                textView {
                    setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_landscape, 0, 0, 0)
                }
                textView {
                    setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_brightness, 0, 0, 0)
                }
                textView {
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