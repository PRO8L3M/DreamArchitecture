package com.example.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.core.Event
import com.example.domain.models.Car
import com.example.home.events.AddCar
import com.example.home.state.CarButtonUiState
import com.example.home.state.CarsUiState
import com.example.home.state.HomeState
import com.example.home.state.MotorcycleUiState
import com.example.home.state.PlanesUiState
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun HomeRoute(viewModel: HomeViewModel = hiltViewModel()) {
    HomeScreen(
        screenState = viewModel.viewState,
        onEvent = viewModel::setEvent,
    )
}

@Composable
@Preview(showBackground = true)
fun HomeScreen(
    screenState: HomeState = HomeState.init(),
    onEvent: (Event) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        val itemSize = LocalConfiguration.current.screenWidthDp.dp / 2
        Text(text = stringResource(id = screenState.planeHeaderRes))
        FlowRow(mainAxisSize = SizeMode.Expand, mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween) {

            when (val state = screenState.planes) {
                is PlanesUiState.Loading -> {
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator()
                    }
                }

                is PlanesUiState.Success -> {
                    state.planes.forEach { plane ->
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(plane.imageUrl)
                                .crossfade(true)
                                .build(),
                            contentScale = ContentScale.Fit,
                            contentDescription = "${plane.company} ${plane.model}",
                            modifier = Modifier.size(itemSize),
                        )
                    }
                }

                is PlanesUiState.Error -> {
                    //todo Show snackbar Error or some static info in place of list
                    Text(text = state.error.toString())
                }
            }
        }
        Text(text = stringResource(id = screenState.carHeaderRes))
        FlowRow(mainAxisSize = SizeMode.Expand, mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween) {
            when (val state = screenState.cars) {
                is CarsUiState.Loading -> {
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator()
                    }
                }

                is CarsUiState.Success -> {
                    state.cars.forEach { car ->
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(car.imageUrl)
                                .crossfade(true)
                                .build(),
                            contentScale = ContentScale.Fit,
                            contentDescription = "${car.make} ${car.model}",
                            modifier = Modifier.size(itemSize),
                        )
                    }
                    if (state.cars.size < 5) {
                        when(screenState.carButton) {
                            is CarButtonUiState.Loading -> {}
                            is CarButtonUiState.Default -> {}
                            is CarButtonUiState.Error -> {}
                        }
                        Button(onClick = {
                            val car = Car(
                                id = 5,
                                make = "BMW",
                                model = "Series 2",
                                imageUrl = "https://www.bmw.pl/content/dam/bmw/common/all-models/2-series/coupe/2021/navigation/bmw-2-series-coupe-ag-modelfinder-890x501.png",
                            )
                            onEvent(AddCar(car))
                        },
                            enabled = screenState.carButton !is CarButtonUiState.Loading
                        ) {
                            if (screenState.carButton is CarButtonUiState.Loading) {
                                CircularProgressIndicator()
                            } else {
                                Text(text = "Add car")
                            }
                        }
                    }
                }

                is CarsUiState.Error -> {
                    //todo Show snackbar Error or some static info in place of list
                    Text(text = state.error.toString())
                }
            }
        }
        Text(text = stringResource(id = screenState.motorcycleHeaderRes))
        FlowRow(mainAxisSize = SizeMode.Expand, mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween) {
            when (val state = screenState.motorcycles) {
                is MotorcycleUiState.Loading -> {
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator()
                    }
                }

                is MotorcycleUiState.Success -> {
                    state.motorcycles.forEach { motorcycle ->
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(motorcycle.imageUrl)
                                .crossfade(true)
                                .build(),
                            contentScale = ContentScale.Fit,
                            contentDescription = "${motorcycle.make} ${motorcycle.model}",
                            modifier = Modifier.size(itemSize),
                        )
                    }
                }

                is MotorcycleUiState.Error -> {
                    //todo Show snackbar Error or some static info in place of list
                    Text(text = state.error.toString())
                }
            }
        }
    }
}
