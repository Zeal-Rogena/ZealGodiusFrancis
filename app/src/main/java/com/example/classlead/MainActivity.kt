package com.example.classlead

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classlead.data.datasource
import com.example.classlead.model.grouppackage
import com.example.classlead.ui.theme.ClassLeadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassLeadTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Groupapp()


                }
            }
        }
    }
}

@Composable
fun Groupapp(){
        GroupPackageList(
            groupList = datasource().loadgrouppackages()
        )
}

@Composable
fun GroupPackageList(
    groupList: List<grouppackage>, // Renamed for clarity
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(groupList) {
                grouppackage ->  // Use the actual item
            DopeCard(
                group = grouppackage, // Pass the entire AestheticPackage
                modifier = Modifier.padding(10.dp)
            )
        }


    }
}
@Composable
fun DopeCard(group: grouppackage, modifier: Modifier=Modifier){
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = (group.imageResourceId)),
                contentDescription = stringResource(id = group.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), contentScale = ContentScale.Crop


            )
            Text(text = LocalContext.current.getString(group.stringResourceId),
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.headlineMedium
            )

        }


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClassLeadTheme {
        Groupapp()

    }
}