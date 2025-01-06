package com.example.whereismyauto.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.whereismyauto.R
import com.example.whereismyauto.ui.theme.color_primary
import com.example.whereismyauto.ui.theme.color_white

@Composable
fun splashScreen() {
    Column(
        modifier = Modifier
            .background(color = color_primary)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.app_name)
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = typography.headlineLarge.copy(color = color_white)
        )
        Text(
            text = stringResource(id = R.string.need_a_ride),
            style = typography.titleMedium.copy(color = color_white)
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}