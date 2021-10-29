package com.example.ui_design_copy.ui.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable

@Composable
fun ProfilesCenteredGridLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val rowHeights = mutableListOf<Int>()
        val rowWidths = mutableListOf<Int>()
        val layoutAssignations = mutableListOf<MutableList<Placeable>>()

        var currRowWidth = 0
        var currRowMaxHeight = 0
        var currRowAssignations = mutableListOf<Placeable>()
        val maxWidth = constraints.maxWidth
        val placeables = measurables.mapIndexed { i, m ->
            val placeable = m.measure(constraints)
            when {
                currRowWidth + placeable.width > maxWidth -> {
                    rowWidths.add(currRowWidth)
                    rowHeights.add(currRowMaxHeight)
                    layoutAssignations.add(currRowAssignations)
                    currRowWidth = placeable.width
                    currRowMaxHeight = placeable.height
                    currRowAssignations = mutableListOf(placeable)
                    if (i == measurables.size - 1) {
                        rowWidths.add(currRowWidth)
                        rowHeights.add(currRowMaxHeight)
                        layoutAssignations.add(currRowAssignations)
                    }

                }
                i == measurables.size - 1 -> {
                    currRowWidth += placeable.width
                    if (placeable.height > currRowMaxHeight) {
                        currRowMaxHeight = placeable.height
                    }
                    rowWidths.add(currRowWidth)
                    rowHeights.add(currRowMaxHeight)
                    currRowAssignations.add(placeable)
                    layoutAssignations.add(currRowAssignations)
                }
                else -> {
                    currRowWidth += placeable.width
                    if (placeable.height > currRowMaxHeight) {
                        currRowMaxHeight = placeable.height
                    }
                    currRowAssignations.add(placeable)
                }
            }
            placeable
        }
        val layoutHeight = rowHeights.sum()
        val layoutWidth = if (placeables.all { it.width < maxWidth }) {
            constraints.maxWidth
        } else {
            placeables.maxOf { it.width }
        }
        layout(layoutWidth, layoutHeight) {
            var currHeight = 0
            layoutAssignations.forEachIndexed { i, row ->
                var currOffsetX = (layoutWidth - rowWidths[i]) / 2
                row.forEach {
                    it.placeRelative(
                        currOffsetX,
                        currHeight
                    )
                    currOffsetX += it.width
                }
                currHeight += rowHeights[i]
            }
        }
    }
}

