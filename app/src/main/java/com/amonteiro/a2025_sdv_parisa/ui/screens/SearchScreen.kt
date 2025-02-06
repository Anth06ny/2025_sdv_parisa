package com.amonteiro.a2025_sdv_parisa.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.amonteiro.a2025_sdv_parisa.ui.theme._2025_sdv_parisaTheme
import com.amonteiro.a2025_sdv_parisa.viewmodel.MainViewModel

@Composable
fun SearchScreen(modifier:Modifier = Modifier, mainViewModel: MainViewModel = MainViewModel()) {
    Column (modifier= modifier) {
        println("SearchScreen()")
        Text(text = "Text1",fontSize = 20.sp, modifier = Modifier.background(Color.Green) )
        Spacer(Modifier.size(8.dp))
        Text(text = "Text2",fontSize = 14.sp)

        mainViewModel.dataList.collectAsStateWithLifecycle().value.forEach {
            PictureRowItem(it.title, Color.Red)
        }
    }
}

@Composable
fun PictureRowItem(text:String, color:Color){
    Text(text = text,fontSize = 20.sp, color = color )
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchScreenPreview() {
    //Il faut remplacer NomVotreAppliTheme par le thème de votre application
    //Utilisé par exemple dans MainActivity.kt sous setContent {...}
    _2025_sdv_parisaTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SearchScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}