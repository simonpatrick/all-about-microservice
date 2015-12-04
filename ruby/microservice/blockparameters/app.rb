#
#
# DataMapper::setup(:default,"sqlite3://#{Dir.pwd}/bookmarks.db")
# DataMapper

require 'sinatra'

get '/' do
  'Hello World'
end

get '/home' do
  'This is my home!'
end

get '/home/:name' do
  "Hello #{params['name']}"
end

get '/say/*/to/*' do
  params['splat']
end

get '/download/*.*' do
  params['splat']
end

get /\A\/hello\/([\w]+)\z/ do
  "Hello, #{params['captures'].first}!"
end

get %r{/hello/([\w]+)} do |c|
  "Hello, #{c}!"
end

get '/foo', :agent => /Songbird (\d\.\d)[\d\/]*?/ do
  "你正在使用Songbird，版本是 #{params['agent'][0]}"
end

get '/foo' do
  # 匹配除Songbird以外的浏览器
  'not songbird browser'
end

get '/', :host_name => /^admin\./ do
  '管理员区域，无权进入！'
end

get '/', :provides => 'html' do
  haml :index
end

get '/', :provides => %w(rss atom xml) do
  builder :feed
end

set(:probability) { |value| condition { rand <= value } }

get '/win_a_car', :probability => 0.1 do
  'You won!'
end

get '/win_a_car' do
  'Sorry, you lost.'
end

options '/' do
  'options'
end

class Stream
  def each
    100.times { |i| yield "#{i}\n" }
  end
end

get '/stream' do
  Stream.new
end

class AllButPattern
  Match =Struct.new(:capture)

  def initialize(except)
    @except=except
    @capture=Match.new()
  end

  def match(str)
    @capture unless @except ===str
  end
end

def all_but(pattern)
  AllButPattern.new(pattern)
end

get all_but('/index') do
  return 'index'
end

get // do
  pass if request.path_info =="/index"
  request.path_info
end

get %r{^(?!/index$)} do
  # ...
end

# static file
set :public_folder, File.dirname(__FILE__)+'static'
set :views, File.dirname(__FILE__)+'templates'

## HAML template
require 'haml'

get '/' do
  haml :index
end

set :haml, {:format => :html5}

get '/html4' do
  haml :index, :haml_options => {:format => :html4}
end

require 'erb'
Title.register :erb, Title[:erubis]

get '/erb' do
  erubis :index
end

require 'builder'
get '/builder' do
  builder :index
end

require 'tilt/nokogiri'

go '/nokogiri' do
  nokogiri :index
end

require 'tilt/sass'
set :sass, {:style => :compact}

get '/stylesheet.css' do
  sass :stylesheet
end


require 'tilt/liquid'
get '/liquid' do
  liquid :index, :locals => {:key => 'value'}
end

get '/tea' do
  status 418
  headers \
    "Allow" => "BREW,POST,GET,WHEN",
    "Refresh" => "Refresh: 20;http://ietf.org/rfc...."
  body "I'm a tea pot!"
end






