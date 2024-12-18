@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.plcoding.fabexplode

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SharedTransitionScope.MainScreen(
    fabColor: Color,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onFabClick: () -> Unit,
) {
   Scaffold(
       floatingActionButton = {
           FloatingActionButton(
               onClick = onFabClick,
               containerColor = fabColor,
               modifier = Modifier
                   .sharedBounds(
                       sharedContentState = rememberSharedContentState(
                           key = FAB_EXPLODE_BOUNDS_KEY
                       ),
                       animatedVisibilityScope = animatedVisibilityScope
                   )
           ) {
               Icon(
                   imageVector = Icons.Default.Add,
                   contentDescription = "Add item"
               )
           }
       }
   ) { innerPadding ->
       Box(
           modifier = Modifier
               .padding(innerPadding)
               .fillMaxSize(),
           contentAlignment = Alignment.Center
       ) {
           Text("Main content")
       }
   }
}