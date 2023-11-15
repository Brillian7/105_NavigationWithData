package com.example.estehjumbo


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitBUttonClicked: (MutableList<String>) -> Unit,
    onCancelButtonClicked: () -> Unit,

    ) {
    var nama by rememberSaveable { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nama, noHp, alamat)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Data Pelanggan")
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            OutlinedTextField(
                value = nama, onValueChange = { nama = it },
                label = { Text(text = stringResource(id = R.string.nama)) })
            OutlinedTextField(
                value = noHp, onValueChange = { noHp = it },
                label = { Text(text = stringResource(id = R.string.noHp)) })
            OutlinedTextField(
                value = alamat, onValueChange = { alamat = it },
                label = {
                    Text(text = stringResource(id = R.string.alamat))
                })
            Spacer(modifier = Modifier.padding(2.dp))
        }
        Column(
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(onClick = onCancelButtonClicked) {
                    Text(stringResource(R.string.cancel))
                }
                Button(onClick = { onSubmitBUttonClicked(listData) }) {
                    Text(text = stringResource(id = R.string.button_submit))
                }

            }
        }
    }
}
