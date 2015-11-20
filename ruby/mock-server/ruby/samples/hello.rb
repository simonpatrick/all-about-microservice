require 'sinatra'
require 'slim'

get '/hello/:name' do
  "Hello #{params[:name]}"
end

post '/hello' do
  params[:name]||="Nobody"
  "Hello #{params[:name]}"
end

get '/' do
  slim :'home/index'
end

set :public_folder,File.dirname(__FILE__)+'/static'
