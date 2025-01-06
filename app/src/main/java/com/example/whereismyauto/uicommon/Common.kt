package com.example.whereismyauto.uicommon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.whereismyauto.R


@Composable
fun AppHeader(
    modifier: Modifier,
    titleText : String =  "Signup for free",
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = typography.headlineLarge
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = titleText,
            style = typography.titleMedium
        )
    }

}